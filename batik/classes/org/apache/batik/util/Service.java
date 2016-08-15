package org.apache.batik.util;
public class Service {
    static java.util.HashMap providerMap = new java.util.HashMap();
    public static synchronized java.util.Iterator providers(java.lang.Class cls) {
        java.lang.String serviceFile =
          "META-INF/services/" +
        cls.
          getName(
            );
        java.util.List l =
          (java.util.List)
            providerMap.
            get(
              serviceFile);
        if (l !=
              null)
            return l.
              iterator(
                );
        l =
          new java.util.ArrayList(
            );
        providerMap.
          put(
            serviceFile,
            l);
        java.lang.ClassLoader cl =
          null;
        try {
            cl =
              cls.
                getClassLoader(
                  );
        }
        catch (java.lang.SecurityException se) {
            
        }
        if (cl ==
              null)
            cl =
              org.apache.batik.util.Service.class.
                getClassLoader(
                  );
        if (cl ==
              null)
            return l.
              iterator(
                );
        java.util.Enumeration e;
        try {
            e =
              cl.
                getResources(
                  serviceFile);
        }
        catch (java.io.IOException ioe) {
            return l.
              iterator(
                );
        }
        while (e.
                 hasMoreElements(
                   )) {
            java.io.InputStream is =
              null;
            java.io.Reader r =
              null;
            java.io.BufferedReader br =
              null;
            try {
                java.net.URL u =
                  (java.net.URL)
                    e.
                    nextElement(
                      );
                is =
                  u.
                    openStream(
                      );
                r =
                  new java.io.InputStreamReader(
                    is,
                    "UTF-8");
                br =
                  new java.io.BufferedReader(
                    r);
                java.lang.String line =
                  br.
                  readLine(
                    );
                while (line !=
                         null) {
                    try {
                        int idx =
                          line.
                          indexOf(
                            '#');
                        if (idx !=
                              -1)
                            line =
                              line.
                                substring(
                                  0,
                                  idx);
                        line =
                          line.
                            trim(
                              );
                        if (line.
                              length(
                                ) ==
                              0) {
                            line =
                              br.
                                readLine(
                                  );
                            continue;
                        }
                        java.lang.Object obj =
                          cl.
                          loadClass(
                            line).
                          newInstance(
                            );
                        l.
                          add(
                            obj);
                    }
                    catch (java.lang.Exception ex) {
                        
                    }
                    line =
                      br.
                        readLine(
                          );
                }
            }
            catch (java.lang.Exception ex) {
                
            }
            catch (java.lang.LinkageError le) {
                
            }
            finally {
                if (is !=
                      null) {
                    try {
                        is.
                          close(
                            );
                    }
                    catch (java.io.IOException ignored) {
                        
                    }
                    is =
                      null;
                }
                if (r !=
                      null) {
                    try {
                        r.
                          close(
                            );
                    }
                    catch (java.io.IOException ignored) {
                        
                    }
                    r =
                      null;
                }
                if (br ==
                      null) {
                    try {
                        br.
                          close(
                            );
                    }
                    catch (java.io.IOException ignored) {
                        
                    }
                    br =
                      null;
                }
            }
        }
        return l.
          iterator(
            );
    }
    public Service() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfXBU1RW/u/n+XgIJiCRACNjwkYVWKjRghRAguAmRYKqL" +
                                                              "sNx9ezd55O17j/fuJpuoFZl2wD/KIAWkrfAXFkupMJ06rW110nHqx2g7g9Ja" +
                                                              "60id2j+0llHG0XZKv869933vJtRxyMy7eXvvuefee87v/M6579wVVGIaqJmo" +
                                                              "tJ2O6cRs71JpHzZMkupUsGluh76E9FgR/njXe72rw6g0jmqHsNkjYZNslImS" +
                                                              "MuOoSVZNilWJmL2EpNiMPoOYxBjBVNbUOGqQze6MrsiSTHu0FGECA9iIoWmY" +
                                                              "UkNOZinpthRQ1BSDnUT5TqLrgsMdMVQtafqYKz7LI97pGWGSGXctk6JIbA8e" +
                                                              "wdEslZVoTDZpR85AS3RNGRtUNNpOcrR9j7LSMsGW2Mo8E7RcqPv02uGhCDfB" +
                                                              "dKyqGuXHM7cRU1NGSCqG6tzeLoVkzL3o66gohqo8whS1xuxFo7BoFBa1T+tK" +
                                                              "we5riJrNdGr8ONTWVKpLbEMUzfcr0bGBM5aaPr5n0FBOrbPzyXDaec5pxSnz" +
                                                              "jnhsSfToY7siPy5CdXFUJ6v9bDsSbILCInEwKMkkiWGuS6VIKo6mqeDsfmLI" +
                                                              "WJHHLU/Xm/KgimkW3G+bhXVmdWLwNV1bgR/hbEZWoprhHC/NAWX9KkkreBDO" +
                                                              "2uieVZxwI+uHA1bKsDEjjQF31pTiYVlNUTQ3OMM5Y+udIABTyzKEDmnOUsUq" +
                                                              "hg5ULyCiYHUw2g/QUwdBtEQDABoUzZ5UKbO1jqVhPEgSDJEBuT4xBFIV3BBs" +
                                                              "CkUNQTGuCbw0O+Alj3+u9K45dL+6WQ2jEOw5RSSF7b8KJjUHJm0jaWIQiAMx" +
                                                              "sXpx7DhufPZgGCEQbggIC5mfPnD1jqXNEy8JmZsLyGxN7iESTUink7UX53S2" +
                                                              "rS5i2yjXNVNmzvednEdZnzXSkdOBYRodjWyw3R6c2PbCvfvOkg/CqLIblUqa" +
                                                              "ks0AjqZJWkaXFWJsIioxMCWpblRB1FQnH+9GZfAek1Uierem0yah3ahY4V2l" +
                                                              "Gv8NJkqDCmaiSniX1bRmv+uYDvH3nI4QKoMHVcOzDIk//p+ivuiQliFRLGFV" +
                                                              "VrVon6Gx85tRYJwk2HYomgTUD0dNLWsABKOaMRjFgIMhYg1wI0CAjMgSaWfI" +
                                                              "0m+Azhw7x/TRUAhMPCcY4ArExmZNSREjIR3Nru+6+lTiFQEeBnjLAsC5sEy7" +
                                                              "WKadLyNcZC2DQiGufQZbToyA6YchiIFFq9v6d27ZfbClCFCjjxaD3Zhoiy+b" +
                                                              "dLqRbtNzQjpfXzM+//KK58OoOIbqsUSzWGHJYZ0xCLQjDVuRWZ2EPOPS/TwP" +
                                                              "3bM8ZWgSSQHbTEb7lpZybYQYrJ+iGR4NdjJiYRedPBUU3D+aODH68MBDy8Mo" +
                                                              "7Gd4tmQJkBOb3sd42eHf1mBkF9Jbd+C9T88ff1BzY9yXMuxMlzeTnaEl6P+g" +
                                                              "eRLS4nn46cSzD7Zys1cAB1MMMQP01hxcw0chHTYds7OUw4HTmpHBChuybVxJ" +
                                                              "hwxt1O3hwJzGmgaBUQahwAY5k6/t10/+4bfvf4lb0ib9Ok+27ie0w0M0TFk9" +
                                                              "p5RpLiK3G4SA3Nsn+r597MqBHRyOILGg0IKtrO0EggHvgAW/+dLeN/90+fSl" +
                                                              "sAthCpk2m4SCJcfPMuO/8BeC5z/sYeTAOgRJ1HdaTDXPoSqdrbzI3RuQlgJB" +
                                                              "zsDRercKMJTTMk4qhMXPv+oWrnj6b4ciwt0K9NhoWXp9BW7/TevRvld2/b2Z" +
                                                              "qwlJLGm69nPFBBNPdzWvMww8xvaRe/i1pu+8iE8CpwOPmvI44dSIuD0Qd+BK" +
                                                              "bovlvL01MHYbaxaaXoz7w8hT3CSkw5c+qhn46LmrfLf+6sjr9x6sdwgUCS/A" +
                                                              "Yg3IanxUzUYbddbOzMEeZgaJajM2h0DZrRO990WUiWuwbByWlYBgza0GkGPO" +
                                                              "ByVLuqTsj796vnH3xSIU3ogqFQ2nNmIecKgCkE7MIeDVnP7VO8Q+RsuhiXB7" +
                                                              "oDwL5XUwL8wt7N+ujE65R8Z/NvMna86cusxhqQsdNzsMO8fHsLwQd4P87Ou3" +
                                                              "/e7Mo8dHRSpvm5zZAvNm/XOrktz/53/k+YVzWoEyIzA/Hj33+OzO2z/g811y" +
                                                              "YbNbc/npCQjanfvFs5lPwi2lvw6jsjiKSFbhO4CVLIvrOBR7pl0NQ3HsG/cX" +
                                                              "bqJK6XDIc06Q2DzLBmnNTYvwzqTZe00Ag1XMhVF4llsYXB7EYAjxly18yiLe" +
                                                              "trFmqcMuJq+sc45ODovKKXRSVKUb2ogMaAVsAgCaXACwNNafTZp0Gx7l1WJC" +
                                                              "uu+WSGPr6o9bBAKaC8h6yspDv/h5PH5LRBLCLYUU+8vJJ8+US29lXviLmHBT" +
                                                              "gQlCruHJ6LcG3tjzKmf2cpbJt9s29eRpyPiejBFxbFJrx/oGyyYbBOPe8zlL" +
                                                              "KJiWgcuWnBEXNXUQMGqXZzdMN+clX8y6zvrhsLLuw1XfXyvMOX+ScHXln7nr" +
                                                              "nYsnx8+fEzmDmZWiJZPdKvOvsqxSWDhFteMC45NNX5l4/92BnWGL5WtZMyBQ" +
                                                              "O4sW4Ew2sMthu5DDVjP8EBHaNzxS98vD9UUboRTpRuVZVd6bJd0pfxCWmdmk" +
                                                              "BzPuBcoNzAhr2nMsI1MUWgxUKaoN1q5izZ1iw2sKUXVukhBlr8vc8OR/pVOk" +
                                                              "HQ87I+bqpskucfwCenr/0VOprU+sEA6v91+MuuDe/6Pf//vV9hPvvFygVq+g" +
                                                              "mr5MISNECWSEJh+6evj91qXXt2uPvPtM6+D6z1Jus77m6xTU7PdcOMTiyQEV" +
                                                              "3MqL+/86e/vtQ7s/Q+U8N2DOoMof9Jx7edMi6UiYX+YF7+d9BPBP6vADrdIg" +
                                                              "NGuofmgtcADwBebYFfCstQCwNsj5Lujy0FTE0cSaXoqqzTHgEUNTocRKBRJA" +
                                                              "8xQLBIovO7bY77v8Wirg0SwtmqDMHZ+T1uQVq9RoTJP4lx4oPPuzuq4Z1GbN" +
                                                              "G6lemOhe1jzgME8dZx6W7kVkse59Qduwn8kcd8z4FKXrN1gDlWeFnV/NgFEZ" +
                                                              "XXC+2GkZdaftmq9x19zj2eIBZ4v1Ljl2U8IvGmzkkcK7dNmKTsFW/0dhyTrW" +
                                                              "6zmKyqzbO6sVZuV9+BMfq6SnTtWVzzx19xucFZwPStUQ3+msoniLIc97qW6Q" +
                                                              "tMxtVy1KI0G5RyhqKPghgaJi9o9v9lEhe4yiSFCWohL+3yt3gqJKVw4KJ/Hi" +
                                                              "FfkeRUUgwl4f123rR1yAiHowF/JTtGPvhuvZ28PqC3wkxz+62oSU7bOS8/lT" +
                                                              "W3rvv/rlJ8RtVlLw+DjTUgW5TNyZHVKbP6k2W1fp5rZrtRcqFtr513eb9u6N" +
                                                              "ex3AxG+eswPXO7PVueW9eXrNc785WPoa5JUdKIQpmr4jv3LO6VnIJjti+Tkb" +
                                                              "EgC/d3a0fXfs9qXpD9/idxOUdyMJyiekS2d2vn5k1mm4n1Z1oxJIgSTHS/oN" +
                                                              "Y+o2Io0YcVQjm1052CJokbHiKwhqGTAx+xzrBDuYs8bpZZ85KGrJ++5a4OMQ" +
                                                              "3ONGibFey6opq6Socnt8X4PtvABUFJjg9njKViyqEEG3RYlYj67b3wiqS3Qe" +
                                                              "lsnCoc/a8/yVNRf+BwJGevWQGQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "vPv33/rbz32jqIL+Lw/sbDmdIgAA");
}
