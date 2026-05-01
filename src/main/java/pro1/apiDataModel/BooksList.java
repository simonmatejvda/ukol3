package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BooksList
{
    @SerializedName("literatura")
    public List<Book> items;
}
