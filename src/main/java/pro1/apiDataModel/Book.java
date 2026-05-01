package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

public class Book
{
    @SerializedName("priorita")
    public String priority;
    @SerializedName("nazev")
    public String title;
    @SerializedName("autor")
    public String author;
}
