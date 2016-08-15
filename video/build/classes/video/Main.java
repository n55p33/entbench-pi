package video;
public class Main implements ent.runtime.ENT_Attributable {
    int width = 0;
    int height = 0;
    public Main(int width, int height) { super();
                                         this.width = width;
                                         this.height = height; }
    public int ENT_attribute() { if (ent.runtime.ENT_Util.Battery.percentRemaining(
                                                                    ) >=
                                       0.75) { return video.EntMode.
                                                        HIGH_MODE;
                                 }
                                 else
                                     if (ent.runtime.ENT_Util.
                                           Battery.
                                           percentRemaining(
                                             ) >=
                                           0.5) {
                                         return video.EntMode.
                                                  MID_MODE;
                                     }
                                     else {
                                         return video.EntMode.
                                                  LOW_MODE;
                                     } }
    public void execute(int timeout) { try { java.lang.String recovstr =
                                               java.lang.System.
                                               getenv(
                                                 "PANDA_RECOVER");
                                             boolean recover = true;
                                             if (recovstr != null &&
                                                   recovstr.
                                                   equals(
                                                     "false")) { recover =
                                                                   false;
                                             }
                                             video.RaspiVid dynvideo =
                                               new video.RaspiVid(
                                               this.
                                                 width,
                                               this.
                                                 height);
                                             video.RaspiVid v;
                                             int fps = 20;
                                             try { v = dynvideo; }
                                             catch (java.lang.RuntimeException e) {
                                                 v =
                                                   dynvideo;
                                                 if (recover) {
                                                     fps =
                                                       10;
                                                 }
                                             }
                                             v.TakeVideo(
                                                 "vid.mp4",
                                                 fps,
                                                 timeout);
                                       }
                                       catch (java.lang.Exception e) {
                                           java.lang.System.
                                             exit(
                                               e.
                                                 hashCode(
                                                   ));
                                       } }
    public static void main(java.lang.String[] args) { if (args.
                                                             length <
                                                             2) {
                                                           java.lang.System.
                                                             err.
                                                             format(
                                                               "usage: [WIDTH] [HEIGHT]\n",
                                                               args[0]);
                                                           java.lang.System.
                                                             exit(
                                                               1);
                                                       }
                                                       int width =
                                                         java.lang.Integer.
                                                         parseInt(
                                                           args[0]);
                                                       int height =
                                                         java.lang.Integer.
                                                         parseInt(
                                                           args[1]);
                                                       ent.runtime.ENT_Util.
                                                         initModeFile(
                                                           );
                                                       int PANDA_RUNS =
                                                         java.lang.Integer.
                                                         parseInt(
                                                           java.lang.System.
                                                             getenv(
                                                               "PANDA_RUNS"));
                                                       for (int k =
                                                              0;
                                                            k <
                                                              PANDA_RUNS;
                                                            k++) {
                                                           long startStamp =
                                                             new java.util.Date(
                                                             ).
                                                             getTime(
                                                               ) /
                                                             1000;
                                                           video.Main maindyn2 =
                                                             new video.Main(
                                                             width,
                                                             height);
                                                           video.Main main2 =
                                                             maindyn2;
                                                           main2.
                                                             execute(
                                                               120000);
                                                           long endStamp =
                                                             new java.util.Date(
                                                             ).
                                                             getTime(
                                                               ) /
                                                             1000;
                                                           ent.runtime.ENT_Util.
                                                             writeModeFile(
                                                               java.lang.String.
                                                                 format(
                                                                   "ERun %d: %d %d\n",
                                                                   k,
                                                                   startStamp,
                                                                   endStamp));
                                                           try {
                                                               java.lang.Thread.
                                                                 sleep(
                                                                   30000);
                                                           }
                                                           catch (java.lang.Exception e) {
                                                               java.lang.System.
                                                                 err.
                                                                 println(
                                                                   e);
                                                           }
                                                       }
                                                       ent.runtime.ENT_Util.
                                                         closeModeFile(
                                                           );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1470704496000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "VEFWMePbLK884R1+1XBjGIlshD3Ajst4ezGX5XxXIsIlInxsGzbrLT9+BvfL" +
       "V+2m5YOvf9C+64Mfn+Y6B8tlP1yMSoYweCc2Z6HBl4Xz2zbJysO8i05tv75D" +
       "PfURcEwBRxlqRGuHCQm0FAAXe3bDgl8+9fTS3a/UkegwaVF1KTsscZwmzQCQ" +
       "1MpD7i0ZV14l8GEaYbGDq0rKlC/rwBhdUzn6hwoG4/E6+/1l37n8+PxbHKgM" +
       "wWOVG6yrA4mZH7q83PDwa5f+9PjXj0wLf6oRHSG65f/YoWb2/fbvZSbnqbBC" +
       "wIToU4kT96wcvOI9Tu/lJKTuL5WXMJDXPdoLHy78Ndrb+EyULEiRDtk+5OyS" +
       "1CIifQoKe8s5+cBBKDAeLNJFRTrg5tzV4Yj1LRvOhv5AqGcBp+8M5oaYkwmd" +
       "X38CjBD+kOIkn+LtRmzO8/uDyypSgxUjDdNKVhSml4m8iu0INtcJPsmqLrgz" +
       "uA4ONdvrNFcROSNExuaGcimrUUMCzVNlMs8qiSnXELPkLXeOuxz/NJJQ6e3P" +
       "vV4oEIz37mqnIw6ux/Ydns/uuP+CqI1CVzEIYN04T6VTVA1FVXcgqkb5edBz" +
       "0TcXHvrdD/ont3ySShf7es5Qy+L7GoiPjdUDNSzKc/v+tHLnFfndn6BoXROy" +
       "UpjlQ6MnXrj6LPlQlB9+ReyUHZqDRAPBiGkxKZzytWCy6AsWjuvgu8re11Vh" +
       "J/Q8J+QSbjlWjTSUdew86KWlmRpp6WZsGIPzY4nKcK7nkwbs9I0/VzJSP6Ur" +
       "Wc+ni2cKvdrojx3jBu83XB05+dnwvcTW8ZIa5gljShQf4xCHFr+e8RAmikxi" +
       "NbhWtlzw9s+t7ngxKWqJ61uf/Yn17d8/LnJMpdoxdN/w4PEm+VeFZ99x4vBS" +
       "V8aVKNLaWpqDOOurB4dPqvkH+l6+Zb7vNzzFNykWhBtEZ4UbFB/NByfefu/V" +
       "9u5HeVjXY/DatU/w6qn8ZilwYcR1imHzNWH95Yx08BSPWSkuro7KzMxhWhDZ" +
       "CHyk9gY35BRNUvlim2C7VapNiuxwBTaHDM/bnMLelmWRJ8ugqmsUTxfOmLgQ" +
       "UPS4e3MHg6WKwhpCWL6YL1K5PDVi7FiNsQew+RaoJqNcQo0a0x+qFk++0PPF" +
       "/1CJU32lBsdHsLkdgrwA5Qo+z3mRfsf/ItJLwBsvYLDsW1524SouCeVH52NN" +
       "y+avfUO4oXOR1wZ5IldUVX9h4ntuNEyaU7gWbaJMEcX4E2BOfvGDL981Kjik" +
       "KJNKkWAydfVecia9ffm3LxCa/N7ZwYKiuHlOyyfnr9l+8+lL7hfHflmVZmeR" +
       "SytEkbiBcPPUuqrcHF6N2zZ8tPCx5vUOknQKgT14XOXb3HFIHsHMXvYPQlou" +
       "PXVuLH7firOjmDtDhWuoRISTwDQ1t+hFLWvDRAPmcBcliobhH65UOyImr7Ch" +
       "rqMiyGNzn+G6Uw/Xp4e/bxWJCdmAV+Wh6jL8/XhqhkPZlYYRmh2Bo2JByfJV" +
       "ngmNwdm6DtTiYy/wCe7Ti/+v15JhhMM5eOzx/WvEr0rS8uvHb3jt0PJjPVHS" +
       "OkIaoPSjJX5u2DqjjVN5ykyRdsUaKsHZCrgAzgXOwAsx4iQEae5ltnO2u714" +
       "BcdIb/nxv/zistxFWr2ewN8LdhSHnQYIvB5fegnsWORzBt7fCJfiLrTIcA05" +
       "js0rHP/4a+k/+rvmTtMbAAA=");
    public Main() { super(); }
    public ent.runtime.ENT_Attributable ENT_copy() {
        video.Main ENT_ld =
          new video.Main(
          );
        ENT_ld.
          width =
          this.
            width;
        ENT_ld.
          height =
          this.
            height;
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1470704496000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3vvFNz157z+kx0BndI8X3Zo7vcJFjUN9vvvUN7795evvfDo9Y756Inpr/3D8" +
       "hsvlF1iO3EtJyb9uf1ZeemV3krn0/NzJOk+9k2apd9Y554cf2Uls5xJVIxvs" +
       "zkM7lhLutaTG9fDu7u4jFzcmNbtsBvcTs5/cJOc/9Vwi2Y94pw3Fmh46Nfgd" +
       "J9rHvzlZ3QtINx8krjHDtpQkDm3a1tcbdHt3/x5SGqSuROk71pSmgx3yDldS" +
       "kcOq/ycntP1ZUvyRnzklJXSt2TgB/DPR+vfpE2A+lxQfAdaU+Mzk/TcOTOqj" +
       "L8Kk0lh0z+XK89fPT3mOrwPSCsl2VuuYlJwxpiqT1hvyni7tV98PNOmBi6/a" +
       "UZaicf8aZO2+06MjAO1rurf+uCLY+kxnA7f+SgD34sIh0IsvIgr81YlR4Csn" +
       "tH01Kb7oZ85spiX5/pkDyf3lCzr4BNJPZi65j3DbZVf21tfMpKefPHfm1ie5" +
       "v1l7mM1VsLNE5owaGMbh879D76cdV1H1lOKz69PA9Tx9DahwGluTj687Vzij" +
       "Wp9GRluHFnB7Kpbyd9Nz8bff5fBdk8TrpjcXNwu0YH138ZL08Sc71KPfQz68" +
       "vusiGWIcJ1jOAAe5vnazv8i7+1mxbXCdxh/4wQ2fOHvfZkF6w5rgA/04RNsr" +
       "rnyxpGE6fnoVJP79W3/31b/15NfTI7P/A/lCfotSKgAA");
}
