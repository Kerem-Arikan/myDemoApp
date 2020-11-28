package myDemoApp;

  import static spark.Spark.get;
  import static spark.Spark.port;
  import static spark.Spark.post;

  import java.util.ArrayList;
  import java.util.HashMap;
  import java.util.Map;

  import spark.ModelAndView;
  import spark.template.mustache.MustacheTemplateEngine;

  public class App
  {
    public static String findPrefix(ArrayList<String> mainList, ArrayList <String> prefix, int asked_num)
    {
      if(mainList.size() == 0 || prefix.size() == 0)
        return "Either of word lists are empty.";
      

      Trie t = new Trie(30);
      for(int i = 0 ; i < mainList.size() ; i++)
        t.insertString(mainList.get(i));
      
      for(int i = 0 ; i < prefix.size() ; i++)
      {
        String pref = t.findPrefix(prefix.get(i));
        if(pref.equals("\0"))
          continue;
        if(pref.length() == asked_num)
          return pref;
      }
      return "Required prefix cannot be found.";
    }

    public static void main(String[] args) {

        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Prefix_Tester");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<String> mainWordList = new java.util.ArrayList<String>();
          while (sc1.hasNext())
          {
            String value = sc1.next().replaceAll("\\s","");
            mainWordList.add(value);
          }
          sc1.close();

          String input2 = req.queryParams("input2");
          java.util.Scanner sc2 = new java.util.Scanner(input2);
          sc2.useDelimiter("[;\r\n]+");
          java.util.ArrayList<String> prefixList = new java.util.ArrayList<String>();
          while (sc2.hasNext())
          {
            String value = sc2.next().replaceAll("\\s","");
            prefixList.add(value);
          }
          sc2.close();


          String input3 = req.queryParams("input3").replaceAll("\\s","");
          int prefixCount = Integer.parseInt(input3);

          String result = App.findPrefix(mainWordList, prefixList, prefixCount);

          Map<String, String> map = new HashMap<String, String>();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map<String, String> map = new HashMap<String, String>();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
