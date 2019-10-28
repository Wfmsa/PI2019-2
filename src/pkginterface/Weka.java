package pkginterface;

import weka.associations.Apriori;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Weka {

    String retornoWeka;

    public Weka() throws Exception {
        Relatorio r = new Relatorio();

        String dataset = (r.arquivo.getAbsolutePath());
        DataSource source = new DataSource(dataset);
        Instances data = source.getDataSet();
        Apriori model = new Apriori();
        model.buildAssociations(data);
        retornoWeka = model.toString();
        //System.out.println(retornoWeka);
        //r.txtCaixa.setText(retornoWeka);
    }

}
