package pkginterface;

import java.util.ArrayList;
import java.util.Arrays;
import weka.associations.Apriori;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.core.converters.ConverterUtils.DataSource;

public class weka {

    public static void main(String[] args) throws Exception {

        Relatorio r = new Relatorio();

        String dataset = convertArrayToString(r.listaProd);
        DataSource source = new DataSource(dataset);
        Instances data = source.getDataSet();
        Apriori model = new Apriori();
        model.buildAssociations(data);
        System.out.println(model);
    }
    
}
