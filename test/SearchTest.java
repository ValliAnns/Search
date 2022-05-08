import org.junit.Assert;
import org.junit.Test;

public class SearchTest {
    @Test
    public void firstTest() {
        Search search = new Search();
        Assert.assertTrue(search.test("December 1990", "1990"));
        Assert.assertTrue(search.test("December1990", "1990"));
        Assert.assertFalse(search.test("December1990", "\"1990\""));
        Assert.assertTrue(search.test("\"What's New!\"", "\"What's\""));
        Assert.assertTrue(search.test("\"What's New!\"", "What's"));
        Assert.assertTrue(search.test("December 1990:", "1990"));
        Assert.assertTrue(search.test("December 1990.", "1990"));
        Assert.assertTrue(search.test("December 1990,", "1990"));
        Assert.assertTrue(search.test("December 1990:", "\"1990\""));
        Assert.assertTrue(search.test("December 1990.", "\"1990\""));
        Assert.assertTrue(search.test("December 1990,", "\"1990\""));
        Assert.assertTrue(search.test("I'll find", "I'll"));
        Assert.assertTrue(search.test("Daughters' party", "Daughters"));
        Assert.assertTrue(search.test("Daughters' party", "\"Daughters\""));
        Assert.assertTrue(search.test("Daughters' party", "\"Daughters\""));
        Assert.assertTrue(search.test("'Birthday party' is arranged", "\"'Birthday party'\""));
    }
}
