package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ThesesList {
    @SerializedName("kvalifikacniPrace")
    public List<Thesis> items;
}
