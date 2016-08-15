package camera;
public class Main implements ent.runtime.ENT_Attributable {
    int width = 0;
    int height = 0;
    public Main(int width, int height) { super();
                                         this.width = width;
                                         this.height = height; }
    public int ENT_attribute() { if (ent.runtime.ENT_Util.Battery.percentRemaining(
                                                                    ) >=
                                       0.75) { return camera.EntMode.
                                                        HIGH_MODE;
                                 }
                                 else
                                     if (ent.runtime.ENT_Util.
                                           Battery.
                                           percentRemaining(
                                             ) >=
                                           0.5) {
                                         return camera.EntMode.
                                                  MID_MODE;
                                     }
                                     else {
                                         return camera.EntMode.
                                                  LOW_MODE;
                                     } }
    int picLapse = 1000;
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
                                             camera.RaspiStill d =
                                               new camera.RaspiStill(
                                               width,
                                               height);
                                             camera.RaspiStill c;
                                             try { c = d; }
                                             catch (java.lang.Exception e) {
                                                 c =
                                                   d;
                                                 if (recover) {
                                                     picLapse =
                                                       1500;
                                                 }
                                             }
                                             c.TakePictures(this.
                                                              picLapse,
                                                            timeout);
                                       }
                                       catch (java.lang.Exception e) {
                                           java.lang.System.
                                             exit(
                                               e.
                                                 hashCode(
                                                   ));
                                       } }
    public static void main(java.lang.String[] args) { if (args.length <
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
                                                           camera.Main maindyn2 =
                                                             new camera.Main(
                                                             width,
                                                             height);
                                                           camera.Main main2 =
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
      1470929475000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "7ecIpZCVT/k2y6tReIdfNdwYRiKLYQ+w43beLuWy3OhKRLhEhI+twWah5cfP" +
       "4H75St4R+eG3LzVtuvSjy1znYM3sh4t1kiEM3oLNtWjwmeH8tkaysjDvlrPr" +
       "721Wz34MHIeBowyForXBhAxaCICLPbtm0i9feHHG1jeqSLSPTFZ1Kd0ncZwm" +
       "9QCQ1MpC8i0YK1YKfBhHWGzmqpIi5Ys6MEbnlY7+3pzBeLzu/P7MZ+44OvE+" +
       "BypD8JjD6auwHggkZn7y8nLD8bdu+9nRbxwaF/5UITpCdLP+sUFN7f3t34tM" +
       "zlNhiYAJ0Q8nTjw+u2f5h5zey0lI3VUormEgr3u0Nx/P/TXaUfuTKJk0TJpl" +
       "+6SzSVLziPTDUN1bzvEHTkOB8WClLsrSbjfnzg1HrG/ZcDb0B0I1Czh9SzA3" +
       "xJxM6Pz6E2CE8JdhTvIp3i7G5ga/P7isIhVYMVIzrqRFdXq7yKvY9mNzj+CT" +
       "LOuCG4Pr4FC9vU59GZFTQmRsNhdLWY4aEmiWKqNZVkpM+SrFnA7PHHuhOWXE" +
       "VCqKWY6aQVWhyEnJsGgpQbdVELTgLXi9uyD/qyWhg4K/SPBiliAwtZU7y/Es" +
       "cGTvwYn0hidvitpwuZIB0ujGDSodo6qPFebqtkD4r+OnVy+W3pty4Hc/6Bpd" +
       "fTUlOfa1X6Hoxu95EMiLyyNKWJSX9v5p9sbl2a1XUV3PC1kpzPKpdSdeueta" +
       "+UCUH9VFkBcd8YNE3cHQnmxSlje1YFbrDFa4C+Bps/e1LeyGnueEXMKtG8uR" +
       "htKjnbC9/LmnQv7ci80uBqfdApXzTJTn3XadgT8rGKke05W059P3Xyn4Kqcp" +
       "7Bg0eP+4qyMnvw6epbaOSyuYJwx+UXyNA2BY/DLJg8IoMolV4FracsG7SrcM" +
       "5VWvKHrubTj3Y+vbv39aJMNSRW7oduTY0Tr5V7lzHzhxeJsr42wUaX4lzUGc" +
       "heWDwyfVxHc6X39govM3vBapUywIN4jOEvc9PppLJ85/+GZT2yke1tUYvHaR" +
       "FrwoK74HC1xvcZ1i2BwS1p/FSDOvRTB9xsVFV5GZOVALIhuDn6i8wTUZRZNU" +
       "vtgy2G6VaqMijS3H5jHD8zbnBGLLMtWTpUfVNYrHIGdM3Fwoety9Z4TBQklh" +
       "x4WwfDFfpHJ5KsTYdyuMncTmGKgmo1xCjQrTz5SLJ1/o+eK/t8CpDlTg+Aw2" +
       "X4Ugz0Fdhe9f9CL9a/+LSC8Ab7wpwvp0VtH1sLjSlE9NxOpmTtz9jnBD59qx" +
       "EfJEJq+q/grK915rmDSjcC0aRT0lTg3PgW+IKyr8et4o4ZGioCtEgtnUVXz6" +
       "lRT3JeDOQGzya3IHDPLionxEPj2xdv2uy7c+KS4oZFXauRO5NEAYibsSN1Et" +
       "KMvN4VW7ZtHHU87UL3SgpEUI7OHjHN/uDkL2CKb2on94jMiFF5bE4t+65roo" +
       "Js9QiR0qZuHMMk7N1XpeS9s4UYNJ3IWJvGH4h0tVuQjKs2ysay6J8tg8Zbj+" +
       "1M71aeffd4rMhGzArbJQHxr+fjzfw/FxhWGEZkfgUJtT0nyV10JjBMZALT72" +
       "Uz7BfXvz//VZMIxwPAcPaL5/cvFLnRH57aOb3zow60h7lDT0kxqo/WiBn3Du" +
       "3KENUnnMHCZNitVbgFMgcAGgC5zWp2DISYjS3Mts52xye/GykJGO4ouK4ivW" +
       "Yhdp8HoC/w2xwzjsNEDg9fjyS2DHIp8z8KZJuBR3oamGa8hBbN7lAMg/C/8B" +
       "hxSYS4IcAAA=");
    public Main() { super(); }
    public ent.runtime.ENT_Attributable ENT_copy() {
        camera.Main ENT_ld =
          new camera.Main(
          );
        ENT_ld.
          width =
          this.
            width;
        ENT_ld.
          height =
          this.
            height;
        ENT_ld.
          picLapse =
          this.
            picLapse;
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1470929475000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "quZB5g2eefbgwwfPPwvWd2tisvLJrHjX8Sj57+r5UbJWzHEuWaXeJW1kVrTz" +
       "pvdmRWfL2g++plnYwr4t/7p6uZZ1s9jxxMK/7a+GxvKjf/CXd4hC7pguULxz" +
       "/Xno5c8+1n7/N/P+Jx4i6/1EfKd7BnH2Sd/y580/23/q6v/cL9zHFx4Wj4J4" +
       "TjCCzO7yIHD1dpE9CPTPtJ8NQrcR161jD/iO85p/atjzvulE48B7Bp2933/O" +
       "He3txOra0YJfO++O9gr5y3QrLnl5Myv+waklRv3ClUiXtjEVciJd+Xpzr7be" +
       "o7PUZE3Xj6i5fhdqfvhVqLmqybqq+ReR89zrJOfN4Hn7ETlvvws54quQc83R" +
       "RUpwPPkigqRXJSjHEu8BT3ulfFg7hLPv1cVD3pO9PgMmwMu3bqCHoluCsSPk" +
       "rStDvLmzGBzYygGFuLkyajmaN4PNa27RMtE73O5/ztGKvmZaga4+dIKMssFW" +
       "6hN/+Klf+udPfwMoVL9wJcyEHejRqREHQba7/Kcvv/j4G174vU/kEQZYAy79" +
       "gRe/kmENLuM4K/Jgx96x+ljGKmMHrihTgufTeVAgS8fcwqf4qfogtLC/B279" +
       "h36ZQL1ec/ejOV6ZRdM4nilDpKEuKkGazsQmXmsNcFWvMA1y3OpYRlLDO9Ux" +
       "PmO5jtuiUxlx4nAxayBe6ltE3BRUw2mFVXKKrcl1TBRhp9UhjWofW0qzdX/h" +
       "kJg+I027XhaEAFPWY3+5sLGN48xYKYRD3mqEagPjBHMmmRWE96vLRqNabyB+" +
       "GOtisNZcqj8sTRcIXo6qrVnYlVbNSt+B58yINKzZJFCX60nRX4fVpCJSVZ7r" +
       "MkM4Mfk251pMzPtYUQMRodA3yyS/6vbXVbNk+T14qiaLEkmZJj2ezieeCccz" +
       "d1SWbX2TRNJ8I6D2ZLB21mtq0l85DkXSDSeky+01NTaZPqWudW6uoTK6FvhJ" +
       "aYGKiMLzoWw3whaumCE19SbOhi1XxzHJdy3dcXqktnQpZ7WW14O5hCaboR2y" +
       "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");
}
