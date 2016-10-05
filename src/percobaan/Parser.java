package percobaan;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package tugasakhir;
//import edu.stanford.nlp.ling.CoreLabel;
//import edu.stanford.nlp.ling.Sentence;
//import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
//import edu.stanford.nlp.process.CoreLabelTokenFactory;
//import edu.stanford.nlp.process.PTBTokenizer;
//import edu.stanford.nlp.process.Tokenizer;
//import edu.stanford.nlp.process.TokenizerFactory;
//import edu.stanford.nlp.trees.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.io.StringReader;
//
//import edu.stanford.nlp.tagger.maxent.MaxentTagger;
//
//public class Parser {  
//    public String hasil ;
//    String kelas = null;
//    MaxentTagger tagger = new MaxentTagger("E://Java_Project//Library//stanford-postagger-2015-12-09//models//english-left3words-distsim.tagger");
//    
//    public ArrayList<HasilEkstraksi> ListHasilNP = new ArrayList<HasilEkstraksi>();
//    
//    public ArrayList<HasilEkstraksi> getListHasilNP() {
//        return ListHasilNP;
//    }
//    
//    //public static List<String> listPhrase = new ArrayList<String>();
//
//    LexicalizedParser lp = LexicalizedParser.loadModel("edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz");
//    
//    public void demoAPI(ArrayList<Sente> RecordData) {
////        ArrayList<Sentence> RecordData
//    // This option shows parsing a list of correctly tokenized words
//    String[] sent = { "This", "is", "an", "easy", "sentence", "." };
//    List<CoreLabel> rawWords = Sentence.toCoreLabelList(sent);
//    Tree parse = lp.apply(rawWords);
////    parse.pennPrint();
////    System.out.println();
//
//    // This option shows loading and using an explicit tokenizer
////    String sent2 = "This is another sentence.";
////    String[] input = {"beautiful girl cry a lot in far kitchen", "this is an esay sentence", "the easy menu is good to use and simple button"};
//  
//  String[] input = {"this camera is perfect for an enthusiastic amateur photographer . ",
//"the pictures are razor-sharp , even in macro . ",
// };
//    
//    for (int i=0; i<RecordData.size(); i++){
////        RecordData.get(i).setTreeNP(parse.pennPrint());
//        HasilEkstraksi he = new HasilEkstraksi();
//        String sent2 = RecordData.get(i).getStopWord();
//        //System.out.println("kalimat: "+RecordData.get(i).getSente());
//        //System.out.println("lemma: "+RecordData.get(i).getLemma());
//        //System.out.println("stop word: "+sent2);
//        //System.out.println(sent2);
//        TokenizerFactory<CoreLabel> tokenizerFactory;
//        tokenizerFactory = (TokenizerFactory<CoreLabel>) PTBTokenizer.factory(new CoreLabelTokenFactory(), "");
//        Tokenizer<CoreLabel> tok = tokenizerFactory.getTokenizer(new StringReader(sent2));
//    
//        List<CoreLabel> rawWords2 = tok.tokenize();
//        parse = lp.apply(rawWords2);
//
//        TreebankLanguagePack tlp = lp.treebankLanguagePack(); // PennTreebankLanguagePack for English
//        GrammaticalStructureFactory gsf = tlp.grammaticalStructureFactory();
//        GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
//        List<TypedDependency> tdl = gs.typedDependenciesCCprocessed();
//        //System.out.println(i+". "+ sent2); //output sentence
//            hasil = tdl.toString(); //bisa
//
//            RecordData.get(i).setParsing(hasil);
//            System.out.println("hasil parse: "+hasil);
//            //coba noun phrase tiga kata
//            //listPhrase.clear();
//            //ListHasil.clear();
//        for (Tree subtree: parse){
//            String np = "";
//            String kandidat = "";
//            if(subtree.label().value().equals("NP")){
//                PredEkstraksi p = new PredEkstraksi();
//                if(subtree.getLeaves().size()==1){
//                    kandidat = subtree.getChildrenAsList().toString();
////                    System.out.println("kandidat np: "+kandidat);
//                    if(kandidat.matches("(.*)NN(.*)")){
////                        System.out.println("NP: "+subtree.getChildrenAsList());
//                        np = subtree.getLeaves().toString().replaceAll("[^A-Za-z]", "");
////                        System.out.println(np);
//                        //simpan
//                        p.setTagNP(kandidat);
//                        p.setAspek(np);
//                        he.ListPrediksi.add(p);
//                    }
//                }
//                else if(subtree.getLeaves().size()==2){
//                    //menggabungkan kata
//                    for(int x=0; x<subtree.getLeaves().size(); x++){
//                        //System.out.println(subtree.getLeaves().get(x).toString());
//                        np = np+subtree.getLeaves().get(x).toString()+" ";
//                    }
//                    kandidat = subtree.getChildrenAsList().toString();
////                    System.out.println("kandidat np: "+kandidat);
//                    //hanya mengambil NP yang mempunyai opini
//                    if(kandidat.matches("(.*)NN(.*)")==true){
//                    if((kandidat.matches("(.*)JJ(.*)")==true) || (kandidat.matches("(.*)RB(.*)")==true)){
////                        System.out.println("NP: "+subtree.getChildrenAsList());
//                        np = np.trim().replaceAll("\\s", " ");
//                    
//                        //simpan NP sebagai aspek
//                        p.setTagNP(kandidat);
//                        p.setAspek(np);
////                        System.out.println(np);
//                        
//                        //pencarian opini
//                        String tag = tagger.tagString(np);
//                        String[] tag_split = tag.split(" ");
//                        for(int z=0; z<=1; z++){
//                            String tag_input = tag_split[z].toString();
//                            //System.out.println(tag_input);
//                            if((tag_split[z].matches("(.*)JJ(.*)")==true) || (tag_split[z].matches("(.*)RB(.*)")==true)){
//                                String[] kanOpini = tag_input.split("_");
//                                String opini = kanOpini[0].toString();
//                                p.setOpini(opini);
//                                //System.out.println("opini: "+opini);
//                                
//                                //cek kedekatan opini
////                                kelas = pmi.getKedekatanOpini(opini);
////                                p.setKelas(kelas);
//                            }
//                            //    if((tag_input.matches("(.*)JJ(.*)")==true)||(tag_input.matches("(.*)RB(.*)")==true)){
////                                System.out.println(tag);
////                            }
//                        }
//                        he.ListPrediksi.add(p);
//                    }
//                    }
//                }
//            }
//        }
//        ListHasilNP.add(he);
//        RecordData.get(i).prediksiNP = he;
//    }
//    } 
//    
//    //coba display feature
//    public String displayHasil(){
//        String a="";
//        for(int x=0; x<ListHasilNP.size(); x++){
//            a=a+x+". "+ListHasilNP.get(x).displayEkstraksi()+"\n";
//        }    
//        return a;
//    }
//    //coba display polaritas
//    public String displayPol(){
//        String a="";
//        for(int x=0; x<ListHasilNP.size(); x++){
//            a=a+x+". "+ListHasilNP.get(x).displayOpini()+"\n";
//        }
//        return a;
//    }
//}