package org.apache.batik.bridge;
public class DefaultScriptSecurity implements org.apache.batik.bridge.ScriptSecurity {
    public static final java.lang.String DATA_PROTOCOL = "data";
    public static final java.lang.String ERROR_CANNOT_ACCESS_DOCUMENT_URL =
      "DefaultScriptSecurity.error.cannot.access.document.url";
    public static final java.lang.String ERROR_SCRIPT_FROM_DIFFERENT_URL =
      "DefaultScriptSecurity.error.script.from.different.url";
    protected java.lang.SecurityException se;
    public void checkLoadScript() { if (se != null) { throw se; } }
    public DefaultScriptSecurity(java.lang.String scriptType, org.apache.batik.util.ParsedURL scriptURL,
                                 org.apache.batik.util.ParsedURL docURL) {
        super(
          );
        if (docURL ==
              null) {
            se =
              new java.lang.SecurityException(
                org.apache.batik.bridge.Messages.
                  formatMessage(
                    ERROR_CANNOT_ACCESS_DOCUMENT_URL,
                    new java.lang.Object[] { scriptURL }));
        }
        else {
            java.lang.String docHost =
              docURL.
              getHost(
                );
            java.lang.String scriptHost =
              scriptURL.
              getHost(
                );
            if (docHost !=
                  scriptHost &&
                  (docHost ==
                     null ||
                     !docHost.
                     equals(
                       scriptHost))) {
                if (!docURL.
                      equals(
                        scriptURL) &&
                      (scriptURL ==
                         null ||
                         !DATA_PROTOCOL.
                         equals(
                           scriptURL.
                             getProtocol(
                               )))) {
                    se =
                      new java.lang.SecurityException(
                        org.apache.batik.bridge.Messages.
                          formatMessage(
                            ERROR_SCRIPT_FROM_DIFFERENT_URL,
                            new java.lang.Object[] { scriptURL }));
                }
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YfWwcRxWfO387/s6HTT7sxHFS5euuIU2gdWjrnM+Jw/lD" +
                                                              "ZyeiDs1lbm/O3nhvd7M7a58dAm0KSugfUQhpGkprCclRIEqbClGVQlsFVdBW" +
                                                              "BaS24aOgpgj+IFAiGiEKIkB5M7N3u7f3EcIfWNq58cybN++9ee/33szF66jC" +
                                                              "NFA7UWmAzujEDIRVOowNkyRCCjbNURiLSY+X4b/svzZ4tx9VjqGGCWwOSNgk" +
                                                              "fTJREuYYWiGrJsWqRMxBQhJsxbBBTGJMYSpr6hhaLJv9KV2RJZkOaAnCCPZi" +
                                                              "I4KaMaWGHLco6bcZULQiApIEuSTBHu90dwTVSZo+45C3uchDrhlGmXL2Milq" +
                                                              "ihzEUzhoUVkJRmSTdqcNtEHXlJlxRaMBkqaBg8pW2wS7I1vzTND5bOOHN09O" +
                                                              "NHETLMSqqlGunhklpqZMkUQENTqjYYWkzEPo86gsgha4iCnqimQ2DcKmQdg0" +
                                                              "o61DBdLXE9VKhTSuDs1wqtQlJhBFq3KZ6NjAKZvNMJcZOFRTW3e+GLRdmdVW" +
                                                              "aJmn4mMbgqcf39/07TLUOIYaZXWEiSOBEBQ2GQODklScGGZPIkESY6hZhcMe" +
                                                              "IYaMFXnWPukWUx5XMbXg+DNmYYOWTgy+p2MrOEfQzbAkqhlZ9ZLcoez/KpIK" +
                                                              "Hgddlzi6Cg372DgoWCuDYEYSg9/ZS8onZTVBUYd3RVbHrk8DASytShE6oWW3" +
                                                              "KlcxDKAW4SIKVseDI+B66jiQVmjggAZFS4syZbbWsTSJx0mMeaSHblhMAVUN" +
                                                              "NwRbQtFiLxnnBKe01HNKrvO5Prj9xGF1l+pHPpA5QSSFyb8AFrV7FkVJkhgE" +
                                                              "4kAsrFsfOYOXvHTcjxAQL/YQC5rnP3fj/o3tl18TNMsK0AzFDxKJxqT5eMOb" +
                                                              "y0Pr7i5jYlTrmimzw8/RnEfZsD3TndYBYZZkObLJQGbycvRHDzx0gbzvR7X9" +
                                                              "qFLSFCsFftQsaSldVoixk6jEwJQk+lENURMhPt+PqqAfkVUiRoeSSZPQflSu" +
                                                              "8KFKjf8PJkoCC2aiWujLalLL9HVMJ3g/rSOEquBD2+HrQOKP/1J0IDihpUgQ" +
                                                              "S1iVVS04bGhMfzMIiBMH204E4+D1k0FTswxwwaBmjAcx+MEEsSfihpwYJ8Fe" +
                                                              "ksSWQkckQ9bpCJEsQ6YzAeZp+v9hjzTTc+G0zwdHsNwLAArEzi5NSRAjJp22" +
                                                              "doRvPBN7QzgXCwjbQhRtgm0DYtsA3zYgtg0U3Bb5fHy3RWx7cdhwVJMQ9IC6" +
                                                              "detGHtx94HhnGXiZPl0OdmaknTnZJ+QgQwbOY9KllvrZVVc3v+JH5RHUgiVq" +
                                                              "YYUlkx5jHGBKmrQjuS4OeclJDytd6YHlNUOTSALQqViasLlUa1PEYOMULXJx" +
                                                              "yCQvFqbB4qmjoPzo8tnph/d+4U4/8udmBLZlBYAZWz7McDyL111eJCjEt/HY" +
                                                              "tQ8vnTmiOZiQk2IymTFvJdOh0+sPXvPEpPUr8XOxl450cbPXAGZTDDEGcNju" +
                                                              "3SMHcroz8M10qQaFk5qRwgqbyti4lk4Y2rQzwh21mfcXgVssYDG4Er7ddlDy" +
                                                              "Xza7RGdtq3Bs5mceLXh6+NSI/tQvf/qHLdzcmUzS6CoBRgjtdqEXY9bCcarZ" +
                                                              "cdtRgxCge/fs8Fcfu35sH/dZoFhdaMMu1oYAteAIwcxfeu3QO+9dnb/id/yc" +
                                                              "Qvq24lAFpbNKsnFUW0JJ2G2tIw+gnwLowLyma48K/iknZRxXCAusfzau2fzc" +
                                                              "n040CT9QYCTjRhtvzcAZ/9gO9NAb+//Wztn4JJZ9HZs5ZALSFzqcewwDzzA5" +
                                                              "0g+/teJrr+KnIDkAIJvyLOEYW8ZtUMY1b4NijK9kiTYgEm1moiMPakS24KXK" +
                                                              "nmiEkX2SH/1WvuRO3t7FzMZ3QHyumzVrTHcI5Uapq9aKSSevfFC/94OXb3Cd" +
                                                              "c4s1t8cMYL1bOClr1qaBfasX4nZhcwLo7ro8+Nkm5fJN4DgGHCWAbnPIAJhN" +
                                                              "5/iXTV1R9asfvLLkwJtlyN+HahUNJ/owD1VUAzFCzAlA6LR+3/3CRaaroWni" +
                                                              "qqI85fMG2DF1FHaAcEqn/Mhmv9v6ne3n565yX9UFj2V8fTlLGjnYzEt+Bx4u" +
                                                              "vP2Jn53/yplpUTSsK46JnnVt/xhS4kd/+/c8k3M0LFDQeNaPBS8+uTR07/t8" +
                                                              "vQNLbHVXOj/RAbQ7az9+IfVXf2flD/2oagw1SXaJvRcrFgv2MSgrzUzdDWV4" +
                                                              "znxuiSjqoe4s7C73QqJrWy8gOgkW+oya9es9GNjGjnCbjYMZPMzBQB+gSnkC" +
                                                              "U8z+HeAL7+DtetZsEkHHugFAH5OX8xQEkVWseFCotcQ2FNX39oz2xIajQ6ND" +
                                                              "oSEehNsE/LJ2O2sGBb/7irrpzly1QvCttfdbU0itbYVrGmIYmhGQuMsERGQF" +
                                                              "EppkpZibWgaviD9TyhCsibJmpIAF1hSRCCqJcDQ6FI2FegYHh0ZjPaFQeGQk" +
                                                              "1jsU2jMQHhyN2cjkNcoDt2mUHfBtskXYWMgoW0sZxeSDgaShpQKA7DwdZ22C" +
                                                              "/2ebbCwiEIC1sMlIKNo/PBrriw4NxHr7+/rC0RImif/3Jmlgo6vh22JLsCXP" +
                                                              "JIh3DhbWDexVoxsahSAlCY9i9SXYUuQ3SSYhLXNlKtvc4bRE9EzR4FJtsoRq" +
                                                              "YuoO1mzISsL/KpHn4uFO/w4U+zICrS1WjOf6BEtPK4pdJfk1eP7o6bnE0LnN" +
                                                              "Artbcq9nYdVKPf3zf/04cPY3rxe4EdRQTd+kkCmi5IgIW+ZkiwF+y3ag992G" +
                                                              "U797oWt8x+0U8Wys/RZlOvu/A5RYXzwBeUV59egfl47eO3HgNurxDo85vSy/" +
                                                              "NXDx9Z1rpVN+/qQgckLeU0Tuou7cTFBrEGoZ6mhOPlidWxOvgu8e21/u8QaE" +
                                                              "45EeV8tWmsWWlqimjpeYe5Q1j0ChBO4oTUagdhFuaJasBoYNOQVl95T9PBE8" +
                                                              "0vLe5JPXnhae6E39HmJy/PSjHwVOnBZeKR58Vue9ubjXiEcfLm6TMMhH8OeD" +
                                                              "79/sY7qwAfYLCT5kvzyszD49sJrIQKtKicW36Pv9pSPf/+aRY37bNochN09p" +
                                                              "csJBiC/eCvxK13JsIKynKVpcMA2wWq8t741PvEtJz8w1VrfO7fkFD73s21Ed" +
                                                              "BFHSUhR3NeLqV+oGScpcmTpRm+j85+sUtRaBIagzRIeL/4Sgn4OK30sPdQj/" +
                                                              "ddN9g6Jahw5YiY6bZJ6iMiBh3XN6geuEKMrSPhcu2abkJ7D4VieQXeK+5zEH" +
                                                              "5m+smci3xCtrTLo0t3vw8I1t58Q9U1Lw7CzjsiCCqsSVN4seq4pyy/Cq3LXu" +
                                                              "ZsOzNWsy/tMsBHZiepkr8MKAtzo78aWeS5jZlb2LvTO//eWfHK98C0JlH/Jh" +
                                                              "ihbuyy9f07oFsL0v4gC3642e3w671z0xc+/G5J9/zS8INtAvL04fk66cf/Dt" +
                                                              "U23zcItc0I8qIDRImtfVvTNqlEhTxhiql81wGkQELjJW+lG1pcqHLNKfiKAG" +
                                                              "5pyYXQq5XWxz1mdH2SsFRZ35IZ//tgOXqWli7NAsNcHxFJDeGcl5/M0AsKXr" +
                                                              "ngXOSPYoF+XrHpN6v9z44smWsj4IsBx13OyrTCueBXf3e7CD9k2sOZkWYFQW" +
                                                              "iwzoegacylbowuOfFzRsnCLfenuUQYVPJGL27/c4uxd4lzUv/gfkhTTV6hkA" +
                                                              "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fSs/Ev0/PFbdlfMkAAA=");
}
