package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TerminyList {
    @SerializedName("termin")
    public List<Termin> items;
}
