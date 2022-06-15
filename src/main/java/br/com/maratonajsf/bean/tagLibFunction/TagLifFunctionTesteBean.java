package br.com.maratonajsf.bean.tagLibFunction;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import static java.util.Arrays.asList;

@Named
@ViewScoped
public class TagLifFunctionTesteBean implements Serializable {
    private List<String> names = asList("shimazu toyohisa", "odo nobunaga", "nasu no youchi");

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
}
