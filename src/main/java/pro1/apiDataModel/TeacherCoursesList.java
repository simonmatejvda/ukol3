package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeacherCoursesList
{
    @SerializedName("predmetUcitele")
    public List<TeacherCourse> items;
}
