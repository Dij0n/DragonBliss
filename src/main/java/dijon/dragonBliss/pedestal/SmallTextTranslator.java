package dijon.dragonBliss.pedestal;

import java.util.HashMap;

public class SmallTextTranslator {

    public static final HashMap<String, String> smallTextMap = new HashMap<>();
    public static final HashMap<String, String> boldNumberMap = new HashMap<>();

    public static void initialize(){
        smallTextMap.put("a", "ᴀ");
        smallTextMap.put("b", "ʙ");
        smallTextMap.put("c", "ᴄ");
        smallTextMap.put("d", "ᴅ");
        smallTextMap.put("e", "ᴇ");
        smallTextMap.put("f", "ꜰ");
        smallTextMap.put("g", "ɢ");
        smallTextMap.put("h", "ʜ");
        smallTextMap.put("i", "ɪ");
        smallTextMap.put("j", "ᴊ");
        smallTextMap.put("k", "ᴋ");
        smallTextMap.put("l", "ʟ");
        smallTextMap.put("m", "ᴍ");
        smallTextMap.put("n", "ɴ");
        smallTextMap.put("o", "ᴏ");
        smallTextMap.put("p", "ᴘ");
        smallTextMap.put("q", "ǫ");
        smallTextMap.put("r", "ʀ");
        smallTextMap.put("s", "ѕ");
        smallTextMap.put("t", "ᴛ");
        smallTextMap.put("u", "ᴜ");
        smallTextMap.put("v", "ᴠ");
        smallTextMap.put("w", "ᴡ");
        smallTextMap.put("x", "х");
        smallTextMap.put("y", "ʏ");
        smallTextMap.put("z", "ᴢ");
    }

    public static String smallText(String string){
        String[] strings = string.split("");
        StringBuilder fin = new StringBuilder();

        for(String s : strings){
            fin.append(smallTextMap.getOrDefault(s, s));
        }

        return fin.toString();
    }

}
