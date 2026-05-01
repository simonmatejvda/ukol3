package pro1.reports.report1;

import com.google.gson.Gson;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import pro1.ResourcesUtils;
import pro1.TestDataSource;

import java.io.IOException;

public class TeacherBooksReportingTest
{
    @Test
    void test01() throws IOException, JSONException {
        var actual = TeacherBooksReporting.GetReport(new TestDataSource(), "2025", 247582, "KIKM");
        var actualJson = new Gson().toJson(actual);
        var expectedJson = ResourcesUtils.readResourceFile("expectedReports/teacherBooks_2025_247582_KIKM.json");
        JSONAssert.assertEquals(
                expectedJson,
                actualJson,
                JSONCompareMode.LENIENT);
    }
}