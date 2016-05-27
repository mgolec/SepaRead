package com.cactuscode;

import jdk.internal.org.xml.sax.XMLReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        GroupHeader GrpHdr = new GroupHeader();
        //PaymentInformation PmtInf = new PaymentInformation();
        //CreditTransferTransactionInformation CdtTrfTxInf = new CreditTransferTransactionInformation();

        List<PaymentInformation> ListOfPmtInf = new ArrayList<PaymentInformation>();
        List<CreditTransferTransactionInformation> ListOfCdtTrfTxInf = new ArrayList<CreditTransferTransactionInformation>();


        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder dBuilder = builderFactory.newDocumentBuilder();
            Document document = dBuilder.parse(XMLReader.class.getResourceAsStream("/com/cactuscode/test.xml"));
            //document.normalize();

//            NodeList rootNodes = document.getElementsByTagName("CstmrCdtTrfInitn"); //Lista root elemenata, u ovom slučaju samo jedan, ali može ih biti više
//            Node rootNode = rootNodes.item(0); //pošto je jedan root node stavljamo ga direktno u varijablu
//            Element rootElement = (Element) rootNode; //postavlja odabrani element na root da možemo pretražiti njegove nodove
//            NodeList catchNode = rootElement.getElementsByTagName("GrpHdr");  //uzima listu podnodova
//
//            Node groupHeader = catchNode.item(0);
//            Element groupHeaderElement = (Element) groupHeader;
//
//
//            Node groupElement = groupHeaderElement.getElementsByTagName("MsgId").item(0);
//            Element msg = (Element) groupElement;
//            System.out.println(msg.getTextContent());

            // RecursivelyReadXML(document.getDocumentElement());
            // System.out.println("============================");





            Element root = document.getDocumentElement();
            System.out.println(root.getNodeName());

            //dohvaćanje Group Headera
            NodeList partList = document.getElementsByTagName("GrpHdr");
            System.out.println("============================");

            for (int temp = 0; temp < partList.getLength(); temp++) {
                Node node = partList.item(temp);
                System.out.println("");    //Just a separator
                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) node;

                    GrpHdr.setMsgId(eElement.getElementsByTagName("MsgId").item(0).getTextContent());
                    GrpHdr.setCreDtTm(eElement.getElementsByTagName("CreDtTm").item(0).getTextContent());
                    GrpHdr.setNbOfTxs(Integer.parseInt(eElement.getElementsByTagName("NbOfTxs").item(0).getTextContent()));
                    GrpHdr.setNm(eElement.getElementsByTagName("Nm").item(0).getTextContent());

                }
            }

            //dohvaćanje Payment Informationa
            NodeList partList2 = document.getElementsByTagName("PmtInf");



            int num = partList2.getLength();

            for (int i = 0; i < num; i++) {
                ListOfPmtInf.add(new PaymentInformation()); //kreirenje liste Payment informationa


                Element node = (Element) partList2.item(i).getChildNodes();

                NodeList nodeCdt = node.getElementsByTagName("CdtTrfTxInf"); // Dohvaćanje Credit Transfer Transaction Informationona


                //punjenje objekata u listi
                ListOfPmtInf.get(i).setPmtInfId(node.getElementsByTagName("PmtInfId").item(0).getTextContent());
                ListOfPmtInf.get(i).setPmtMtd(node.getElementsByTagName("PmtMtd").item(0).getTextContent());
                ListOfPmtInf.get(i).setIBAN(node.getElementsByTagName("IBAN").item(0).getTextContent());
                ListOfPmtInf.get(i).setNm(node.getElementsByTagName("Nm").item(0).getTextContent());


                for(int j = 0; i<nodeCdt.getLength(); j++){
                    ListOfCdtTrfTxInf.add(new CreditTransferTransactionInformation()); //kreirenje liste Credit Transfer Transaction Informationona
                    Element nodeCTTI = (Element) partList2.item(i).getChildNodes();

                    ListOfCdtTrfTxInf.get(j).setEndToEndId(nodeCTTI.getElementsByTagName("EndToEndId").item(0).getTextContent());
                    ListOfCdtTrfTxInf.get(j).setInstdAmt(Double.parseDouble(nodeCTTI.getElementsByTagName("InstdAmt").item(0).getTextContent()));
                    ListOfCdtTrfTxInf.get(j).setIBAN(nodeCTTI.getElementsByTagName("IBAN").item(0).getTextContent());
                    ListOfCdtTrfTxInf.get(j).setNm(nodeCTTI.getElementsByTagName("Nm").item(0).getTextContent());

                }


            }


//            for (int temp = 0; temp < partList2.getLength(); temp++) {
//                Node node = partList2.item(temp);
//                System.out.println("");    //Just a separator
//                if (node.getNodeType() == Node.ELEMENT_NODE) {
//
//                    Element eElement = (Element) node;
//
//                    PmtInf.setIBAN(eElement.getElementsByTagName("IBAN").item(0).getTextContent());
//                    CdtTrfTxInf.setEndToEndId(eElement.getElementsByTagName("EndToEndId").item(0).getTextContent());
//                }
//            }

            String newLine = System.getProperty("line.separator");
//            System.out.println(GrpHdr.getMsgId() + newLine + GrpHdr.getCreDtTm() + newLine + GrpHdr.getNbOfTxs() + newLine + GrpHdr.getNm() +
//                    newLine +"=============" + newLine + PmtInf.getPmtInfId()+ newLine + PmtInf.getIBAN()+ newLine + PmtInf.getPmtMtd()+ newLine + PmtInf.getNm());
            System.out.println(GrpHdr.getMsgId() + newLine + GrpHdr.getCreDtTm() + newLine + GrpHdr.getNbOfTxs() + newLine + GrpHdr.getNm() +
                                newLine +"=============" + newLine + ListOfPmtInf.get(0).getPmtInfId()+ newLine + ListOfPmtInf.get(0).getIBAN()+ newLine + ListOfPmtInf.get(1).getPmtInfId()+ newLine + ListOfPmtInf.get(1).getIBAN());


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


    }

    //rekurzivna metoda za prolazak kroz sve nodove u XML-u
//    public static void RecursivelyReadXML(Node node) {
//        // do something with the current node instead of System.out
//        System.out.println(node.getNodeName());
//
//        NodeList nodeList = node.getChildNodes();
//        for (int i = 0; i < nodeList.getLength(); i++) {
//            Node currentNode = nodeList.item(i);
//            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
//                //calls this method for all the children which is Element
//                RecursivelyReadXML(currentNode);
//            }
//        }
    public static Element getDirectChild(Element parent, String name)
    {
        for(Node child = parent.getFirstChild(); child != null; child = child.getNextSibling())
        {
            if(child instanceof Element && name.equals(child.getNodeName())) return (Element) child;
        }
        return null;
    }

}


