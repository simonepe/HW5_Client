package e.simone.client.Net;

public interface ResultAppender
{
    public void showResult(String result);


    public void won(String score);

    public void lost(String score, String searchedWord);
}