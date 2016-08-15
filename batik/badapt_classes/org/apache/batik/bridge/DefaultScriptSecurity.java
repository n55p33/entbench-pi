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
    public static final long jlc$SourceLastModified$jl7 = 1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YfWwcRxWfu/N3/J0vkw87cZxU+bprSBNoHZI653PicP7Q" +
                                                              "2YmoQ3OZ25uzN97b3ezO2meHQJuCEvpHFEKahtJaQnIUiNKmQlSl0FZBFbRV" +
                                                              "Aalt+CioKYI/CJSIRoiCCFDezOzd7u3dOYQ/sLRz45k3b957897vvZlLN1C5" +
                                                              "aaBWotIgndKJGYyodBAbJkmGFWyawzAWlx4P4L8cuN5/rx9VjKD6MWz2Sdgk" +
                                                              "PTJRkuYIWi6rJsWqRMx+QpJsxaBBTGJMYCpr6ghaKJu9aV2RJZn2aUnCCPZh" +
                                                              "I4qaMKWGnLAo6bUZULQ8CpKEuCShLu90ZxTVSpo+5ZC3uMjDrhlGmXb2Milq" +
                                                              "jB7CEzhkUVkJRWWTdmYMtF7XlKlRRaNBkqHBQ8oW2wR7olsKTND+bMOHt06N" +
                                                              "NXITzMeqqlGunhkjpqZMkGQUNTijEYWkzcPo8ygQRfNcxBR1RLObhmDTEGya" +
                                                              "1dahAunriGqlwxpXh2Y5VegSE4iilflMdGzgtM1mkMsMHKqorTtfDNquyGkr" +
                                                              "tCxQ8bH1oTOPH2j8dgA1jKAGWR1i4kggBIVNRsCgJJ0ghtmVTJLkCGpS4bCH" +
                                                              "iCFjRZ62T7rZlEdVTC04/qxZ2KClE4Pv6dgKzhF0MyyJakZOvRR3KPu/8pSC" +
                                                              "R0HXRY6uQsMeNg4K1sggmJHC4Hf2krJxWU1S1OZdkdOx49NAAEsr04SOabmt" +
                                                              "ylQMA6hZuIiC1dHQELieOgqk5Ro4oEHRkpJMma11LI3jURJnHumhGxRTQFXN" +
                                                              "DcGWULTQS8Y5wSkt8ZyS63xu9G87eUTdrfqRD2ROEklh8s+DRa2eRTGSIgaB" +
                                                              "OBALa9dFz+JFL53wIwTECz3Egub5z928f0PrldcEzdIiNAOJQ0SicWk2Uf/m" +
                                                              "svDaewNMjCpdM2V2+Hma8ygbtGc6MzogzKIcRzYZzE5eif3ogYcukvf9qKYX" +
                                                              "VUiaYqXBj5okLa3LCjF2EZUYmJJkL6omajLM53tRJfSjskrE6EAqZRLai8oU" +
                                                              "PlSh8f/BRClgwUxUA31ZTWnZvo7pGO9ndIRQJXxoG3xtSPzxX4oOhsa0NAlh" +
                                                              "CauyqoUGDY3pb4YAcRJg27FQArx+PGRqlgEuGNKM0RAGPxgj9kTCkJOjJNRN" +
                                                              "UthS6JBkyDodIpJlyHQqyDxN/z/skWF6zp/0+eAIlnkBQIHY2a0pSWLEpTPW" +
                                                              "zsjNZ+JvCOdiAWFbiKKNsG1QbBvk2wbFtsGi2yKfj++2gG0vDhuOahyCHlC3" +
                                                              "du3Qg3sOnmgPgJfpk2VgZ0banpd9wg4yZOE8Ll1urpteeW3TK35UFkXNWKIW" +
                                                              "Vlgy6TJGAaakcTuSaxOQl5z0sMKVHlheMzSJJAGdSqUJm0uVNkEMNk7RAheH" +
                                                              "bPJiYRoqnTqKyo+unJt8eN8X7vYjf35GYFuWA5ix5YMMx3N43eFFgmJ8G45f" +
                                                              "//Dy2aOagwl5KSabGQtWMh3avf7gNU9cWrcCPxd/6WgHN3s1YDbFEGMAh63e" +
                                                              "PfIgpzML30yXKlA4pRlprLCprI1r6JihTToj3FGbeH8BuMU8FoMr4NtjByX/" +
                                                              "ZbOLdNYuFo7N/MyjBU8PnxrSn/rlT/+wmZs7m0kaXCXAEKGdLvRizJo5TjU5" +
                                                              "bjtsEAJ0754b/OpjN47v5z4LFKuKbdjB2jCgFhwhmPlLrx1+571rs1f9jp9T" +
                                                              "SN9WAqqgTE5JNo5q5lASdlvjyAPopwA6MK/p2KuCf8opGScUwgLrnw2rNz33" +
                                                              "p5ONwg8UGMm60YbbM3DGP7YTPfTGgb+1cjY+iWVfx2YOmYD0+Q7nLsPAU0yO" +
                                                              "zMNvLf/aq/gpSA4AyKY8TTjGBrgNAlzzFijG+EqWaIMi0WYn2gqgRmQLXqrs" +
                                                              "jUUZ2Sf50W/hS+7m7T3MbHwHxOc6WbPadIdQfpS6aq24dOrqB3X7Pnj5Jtc5" +
                                                              "v1hze0wf1juFk7JmTQbYL/ZC3G5sjgHdPVf6P9uoXLkFHEeAowTQbQ4YALOZ" +
                                                              "PP+yqcsrf/WDVxYdfDOA/D2oRtFwsgfzUEXVECPEHAOEzug77hcuMlkFTSNX" +
                                                              "FRUoXzDAjqmtuANE0jrlRzb93cXf2XZh5hr3VV3wWMrXl7GkkYfNvOR34OHi" +
                                                              "25/42YWvnJ0URcPa0pjoWdfyjwElcey3fy8wOUfDIgWNZ/1I6NKTS8Lb3+fr" +
                                                              "HVhiqzsyhYkOoN1Z+/GL6b/62yt+6EeVI6hRskvsfVixWLCPQFlpZutuKMPz" +
                                                              "5vNLRFEPdeZgd5kXEl3begHRSbDQZ9SsX+fBwBZ2hFttHMziYR4G+gBVypKY" +
                                                              "YvZvH194F2/XsWajCDrWDQL6mLycpyCIrGLFg0KL59iGorruruGu+GBsYHgg" +
                                                              "PMCDcKuAX9ZuY02/4LejpJvuylcrDN8ae7/VxdTaWrymIYahGUGJu0xQRFYw" +
                                                              "qUlWmrmpZfCK+DNzGYI1MdYMFbHA6hISQSURicUGYvFwV3//wHC8KxyODA3F" +
                                                              "uwfCe/si/cNxG5m8RnngDo2yE76Ntggbihlly1xGMflgMGVo6SAgO0/HOZvg" +
                                                              "/9kmG0oIBGAtbDIUjvUODsd7YgN98e7enp5IbA6TJP57k9Sz0VXwbbYl2Fxg" +
                                                              "EsQ7h4rrBvaq1g2NQpCSpEexujnYUuQ3STYhLXVlKtvckYxE9GzR4FJtfA7V" +
                                                              "xNRdrFmfk4T/VSDPxcOd/h0o9mUFWlOqGM/3CZaelpe6SvJr8OyxMzPJgfOb" +
                                                              "BHY351/PIqqVfvrn//px8NxvXi9yI6immr5RIRNEyRMRtszLFn38lu1A77v1" +
                                                              "p3/3Qsfozjsp4tlY623KdPZ/GyixrnQC8ory6rE/LhnePnbwDurxNo85vSy/" +
                                                              "1Xfp9V1rpNN+/qQgckLBU0T+os78TFBjEGoZ6nBePliVXxOvhO8+21/u8waE" +
                                                              "45EeV8tVmqWWzlFNnZhj7lHWPAKFErijNB6F2kW4oTlnNTBoyGkouyfs54nQ" +
                                                              "0eb3xp+8/rTwRG/q9xCTE2ce/Sh48ozwSvHgs6rgzcW9Rjz6cHEbhUE+gj8f" +
                                                              "fP9mH9OFDbBfSPBh++VhRe7pgdVEBlo5l1h8i57fXz76/W8ePe63bXMEcvOE" +
                                                              "JicdhPji7cBv7lqODUT0DEULi6YBVuu1FLzxiXcp6ZmZhqrFM3t/wUMv93ZU" +
                                                              "C0GUshTFXY24+hW6QVIyV6ZW1CY6//k6RYtLwBDUGaLDxX9C0M9Axe+lhzqE" +
                                                              "/7rpvkFRjUMHrETHTTJLUQBIWPe8XuQ6IYqyjM+FS7Yp+QksvN0J5Ja473nM" +
                                                              "gfkbazbyLfHKGpcuz+zpP3Jz63lxz5QUPD3NuMyLokpx5c2hx8qS3LK8Knav" +
                                                              "vVX/bPXqrP80CYGdmF7qCrwI4K3OTnyJ5xJmduTuYu/Mbnv5Jycq3oJQ2Y98" +
                                                              "mKL5+wvL14xuAWzvjzrA7Xqj57fDzrVPTG3fkPrzr/kFwQb6ZaXp49LVCw++" +
                                                              "fbplFm6R83pROYQGyfC6untKjRFpwhhBdbIZyYCIwEXGSi+qslT5sEV6k1FU" +
                                                              "z5wTs0sht4ttzrrcKHuloKi9MOQL33bgMjVJjJ2apSY5ngLSOyN5j79ZALZ0" +
                                                              "3bPAGckd5YJC3eNS95cbXjzVHOiBAMtTx82+0rQSOXB3vwc7aN/ImlMZAUaB" +
                                                              "eLRP17PgFNihC49/XtCwcYp86+xRBhU+kYjZv9/j7F7gXda8+B+aCMHN6hkA" +
                                                              "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "6O4/eMfvPP/N8kj0/wBe56yV8yQAAA==");
}
