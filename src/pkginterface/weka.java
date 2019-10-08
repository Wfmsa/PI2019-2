package pkginterface;

import weka.associations.Apriori;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class weka {
    
    public void main(String[] args) throws Exception {

        Relatorio r = new Relatorio();

        String dataset = "C:/Users/aluno/Desktop/Teste.arff";
        DataSource source = new DataSource(dataset);
        Instances data = source.getDataSet();
        Apriori model = new Apriori();
        model.buildAssociations(data);
        System.out.println(model);
    }
/*public weka(){
    System.out.println(this.model);
}*/
}
