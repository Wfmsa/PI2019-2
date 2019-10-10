package pkginterface;

import weka.associations.Apriori;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/*public class Weka {
    String a;
    public Weka() throws Exception {
        //Relatorio r=new Relatorio();
        //String dataset =r.listaProdS ;
        String dataset="C:\\Users\\Wfmsa PC\\Desktop\\Weka_Teste.arff";
        DataSource source = new DataSource(dataset);
        Instances data = source.getDataSet();
        Apriori model = new Apriori();
        model.buildAssociations(data);
        a=model.toString();
        //System.out.println(model);
    }
}*/
public class Weka {
String a;
String arquivo="C:\\Users\\Wfmsa PC\\Desktop\\Weka_Teste.arff";
    public Weka() throws Exception {
    String dataset = arquivo;
    DataSource source = new DataSource(dataset);
    Instances data = source.getDataSet();
    Apriori model = new Apriori();
    model.buildAssociations(data);
    a = model.toString();
    }

}