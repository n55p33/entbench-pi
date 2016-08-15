package video;
public class RaspiVid implements ent.runtime.ENT_Attributable {
    public int ENT_attribute() { java.lang.System.out.format("Snapshot %d\n",
                                                             _vidHeight);
                                 if (_vidHeight >= 1080) { return video.EntMode.
                                                                    HIGH_MODE;
                                 }
                                 else
                                     if (_vidHeight >=
                                           720) {
                                         return video.EntMode.
                                                  MID_MODE;
                                     }
                                     else {
                                         return video.EntMode.
                                                  LOW_MODE;
                                     } }
    private final java.lang.String _raspividPath = "/opt/vc/bin/raspivid";
    private int _vidTimeout = 120000;
    private java.lang.String _vidName = "vid.mp4";
    private int _vidWidth = 1920;
    private int _vidHeight = 1080;
    private int _fps = 30;
    public RaspiVid(int width, int height) { super();
                                             _vidWidth = width;
                                             _vidHeight = height; }
    public void TakeVideo() { try { java.lang.StringBuilder sb = new java.lang.StringBuilder(
                                      _raspividPath);
                                    sb.append(" -n ");
                                    sb.append(" -t " + _vidTimeout);
                                    sb.append(" -w " + _vidWidth);
                                    sb.append(" -h " + _vidHeight);
                                    sb.append(" -fps " + _fps);
                                    sb.append(" -o " + _vidName);
                                    java.lang.System.out.println(
                                                           sb.
                                                             toString(
                                                               ));
                                    java.lang.Runtime.getRuntime(
                                                        ).exec(sb.
                                                                 toString(
                                                                   ));
                                    java.lang.Thread.sleep(_vidTimeout);
                              }
                              catch (java.lang.Exception e) {
                                  java.lang.System.
                                    exit(
                                      e.
                                        hashCode(
                                          ));
                              } }
    public void TakeVideo(java.lang.String name, int fps, int timeout) {
        _vidName =
          name;
        _fps =
          fps;
        _vidTimeout =
          timeout;
        TakeVideo(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1470704446000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAK1ZDWwcRxWeO///nu3EseM4TuI4gfzU15QGGrltfhy7drg4" +
                                                              "lu0acGku670538Z7u5vdOfvi4tJGVAlIRCGkSRBNkFBKSkiaChF+BEWpKvpD" +
                                                              "I6S2gQJSUwRIBEqkRoiCCFDem9m7/bk7BwtO2vHuzLw3771573tvxudvkBLL" +
                                                              "JG1UY51sv0Gtzh6NDUqmRWPdqmRZI9AXlU8USX/ZfX1gU5CUjpHahGTtlCWL" +
                                                              "9ipUjVljZKmiWUzSZGoNUBpDikGTWtSckpiia2OkUbH6k4aqyArbqccoThiV" +
                                                              "zAiplxgzlfEUo/02A0aWRkCSMJckvNU/3BUh1bJu7HemN7umd7tGcGbSWcti" +
                                                              "pC6yV5qSwimmqOGIYrGutEnWGbq6f0LVWSdNs8696kbbBDsiG3NM0P5c6P1b" +
                                                              "RxJ13AQLJE3TGVfPGqKWrk7RWISEnN4elSatfeRRUhQhVa7JjHREMouGYdEw" +
                                                              "LJrR1pkF0tdQLZXs1rk6LMOp1JBRIEZWeJkYkiklbTaDXGbgUM5s3TkxaLs8" +
                                                              "q63QMkfFJ9eFj53YXfftIhIaIyFFG0ZxZBCCwSJjYFCaHKemtTUWo7ExUq/B" +
                                                              "Zg9TU5FUZcbe6QZLmdAkloLtz5gFO1MGNfmajq1gH0E3MyUz3cyqF+cOZX+V" +
                                                              "xFVpAnRd5OgqNOzFflCwUgHBzLgEfmeTFE8qWoyRZX6KrI4dH4cJQFqWpCyh" +
                                                              "Z5cq1iToIA3CRVRJmwgPg+tpEzC1RAcHNBlpKcgUbW1I8qQ0QaPokb55g2II" +
                                                              "ZlVwQyAJI43+aZwT7FKLb5dc+3Nj4N7Dj2h9WpAEQOYYlVWUvwqI2nxEQzRO" +
                                                              "TQpxIAir10aOS4uePxQkBCY3+iaLOd/7zM0t69suvyLmLMkzZ9f4XiqzqHxm" +
                                                              "vPb11u41m4pQjHJDtxTcfI/mPMoG7ZGutAEIsyjLEQc7M4OXh1761GPn6LtB" +
                                                              "UtlPSmVdTSXBj+plPWkoKjUfoBo1JUZj/aSCarFuPt5PyuA9omhU9O6Kxy3K" +
                                                              "+kmxyrtKdf4NJooDCzRRJbwrWlzPvBsSS/D3tEEIKYOHVMNTRMSP/2XknnBC" +
                                                              "T9KwoYQHTR1Vt8IANuNg1kR4SolRPWyZsv02JFmGMqrEOtGDjP+BNo1yLZgO" +
                                                              "BMBkrf6AVcHX+3Q1Rs2ofCy1refms9HXhDOgA9saMVLL+XZm+JJAgLNbiPyF" +
                                                              "9cF2kxCFAIPVa4Yf3rHnUDvonDami0FxnNruSQfdTqhm8DUqX2yomVlxbcOL" +
                                                              "QVIcIQ2SzFKSiui+1ZwA3JAn7dCqHodE4eD1chdeY6IxdZnGAC4K4bbNpVyf" +
                                                              "oib2M7LQxSGTTTBuwoWxPK/85PLJ6cdHP3tnkAS9EI1LlgC6IPkgAmsWQDv8" +
                                                              "oZmPb+jg9fcvHp/VnSD1YH4mVeVQog7t/g33mycqr10uXYo+P9vBzV4BIMok" +
                                                              "cHrApzb/Gh4M6MrgKepSDgrHdTMpqTiUsXElS5j6tNPDPbGevy8EtyjHoKiD" +
                                                              "Z4UdJfwvji4ysG0Snot+5tOC4/V9w8apX/7sjx/h5s5Ae8iVk4cp63LBCTJr" +
                                                              "4MBR77jtiEkpzHv75OCXn7xx8CHuszBjZb4FO7DtBhiBLQQzP/HKvl+9c+3M" +
                                                              "1aDj5wzyaWocypJ0VskAsfGgkJKw2mpHHoAjFWIbvabjQQ38U4kr0rhKMbD+" +
                                                              "GVq14dKfD9cJP1ChJ+NG62/PwOlfvI089truv7VxNgEZ06FjM2eawNgFDuet" +
                                                              "pintRznSj7+x9CsvS6cArQEhLWWGctALchsEvbGO8TScGrcgLpUkbMOUnT/u" +
                                                              "GtwjH+oY/L3IDYvzEIh5jc+Evzj61t4rfJPLMfKxH/WuccU1IITLw+qE8T+A" +
                                                              "XwCef+ODRscOgcMN3XYyWJ7NBoaRBsnXzFG+eRUIzza8M/nU9QtCAX+29E2m" +
                                                              "h4594YPOw8fEzomSYmVOVnfTiLJCqIPNJpRuxVyrcIreP1yc/eEzsweFVA3e" +
                                                              "BNkD9d+FX/zrSufJ37yaB+OLFLssvBvdNgvcC717IxTa/vnQj440FPUCZvST" +
                                                              "8pSm7EvR/pibI1REVmrctVlOqcI73KrhxjASWAt7gB338HYjl+XOrESES0T4" +
                                                              "WB82qyw3fnr3y1X5RuUjV9+rGX3vxze5zt7S2Q0XOyVDGLwem9Vo8CZ/fuuT" +
                                                              "rATMu/vywKfr1Mu3gOMYcJShXrR2mZBE0x5wsWeXlP36hRcX7Xm9iAR7SaWq" +
                                                              "S7FeieM0qQCApFYC8m/a2LxF4MN0uY2KJE1ylM/pwBhdlj/6e5IG4/E68/2m" +
                                                              "79x79vQ1DlSG4LGE05diSeBJzPwA5uSGc29+7Odnv3R8WvjTHNHho2v+xy51" +
                                                              "/MBv/55jcp4K8wSMj34sfP6plu773+X0Tk5C6o50bhkDed2hvetc8q/B9tKf" +
                                                              "BEnZGKmT7QPPqKSmEOnHoMi3MqcgOBR5xr0Fu6hOu7I5t9Ufsa5l/dnQHQjF" +
                                                              "zOP0TgIM4RbeB0+DnRsa/AkwACllYVg3WHhKDo8rWtjECgyKMRwe44w+xNu1" +
                                                              "2NwhEJiRMsNU4KgM+pTEFU1Sfemodo4lGamJZhYZhKKWUzbDYZc7GdqlUxxk" +
                                                              "RG7Gth+bh8QakYJuPJKVoQJ72+FptGVozFGb8JeJ/AoG8DXq06l8Dn6MVEVB" +
                                                              "nRElSeHoxSHGJ31intKvgqfJXq2pgPS6kB6bvbmyFqJmpBxlHbDdR/YJasxT" +
                                                              "0DZ4WuylWgoIOjWnoIWoGalAQT+hxMTJx2/S6XlKugyeVnut1gKSzs4paSFq" +
                                                              "RipR0j6qTCTy7v6j/72oldjbbIubETufqJ/LJ2qQ2NoWomakOBo3rHxCPjGH" +
                                                              "kGlnsXXZxfivlPgOoe7K00kEBLPd0kL3BLy0OHPg2OnYrqc3BO0cvAUcgOnG" +
                                                              "HSqdoqqLFRaASz05ZSe/GXEA+u3ao7/7QcfEtvmc87Cv7TYnOfxeBtlhbeE0" +
                                                              "5Rfl5QN/ahm5P7FnHke2ZT4r+Vl+c+f5Vx9YLR8N8msgkTlyro+8RF3efFFp" +
                                                              "UpYyNW+ptNJ7bEIXXG3v62q/Czqe43OJ7GGkEOkcNddX5xg7hc1xcIgRaZKO" +
                                                              "4lUBn9aFzSbhnJvBtad0JeY49InbRd3chQ92DIlQOeq1zSZ4umwFu+Zvm0Kk" +
                                                              "Pv2LuCBFWZDm8SpK12/NYaoL2HzDbSrs+JpjlrP/D7OkIY1kLmuwRGzOuagV" +
                                                              "l4vys6dD5U2nH3yLx2L2ArAaoiqeUlV3EeN6LzVMGle4OtWipBGF+yWoN6Yy" +
                                                              "Kn3XyFM6iJIqHfBCT1b3xtvp7kKrlZ4o5/fVmYhMiRvrqHzx9I6BR25+9Glx" +
                                                              "RSCr0swMcqmCw4m4rchG9YqC3DK8SvvW3Kp9rmJVBv/qhcCOPy1x7fIQvHhx" +
                                                              "MOc/D1E5/cL6UOfXF384iEjjK3J95SScGqapuU1Pabzyg+NUCSJe9qIlZRju" +
                                                              "YV+dyV0bc0/Idu2S20UFD1zD7+v8e7sIasILzeIE5FTD3Y+HbTjLbTYM32yo" +
                                                              "ZIuS4I3Y8ZJvDI7kRaAhH/tp2nAWdo6hrbnHUMgB/GojKl89+/CbR5vPtAVJ" +
                                                              "VT8pgWRF07zO375fG6LylDlGahSrJw1nIeCiSKrnzFqLXi9hSct32naQmmwv" +
                                                              "Xpkx0p57XM+9aMzdpiqnx/OvgQzU+zYOCJwe15WGx1SBTxp43yK2lRfDC7jl" +
                                                              "rnDPw+YNbHr4Z/o/a4va348bAAA=");
    public RaspiVid() { super(); }
    public ent.runtime.ENT_Attributable ENT_copy() {
        video.RaspiVid ENT_ld =
          new video.RaspiVid(
          );
        ENT_ld.
          _vidTimeout =
          this.
            _vidTimeout;
        ENT_ld.
          _vidName =
          this.
            _vidName;
        ENT_ld.
          _vidWidth =
          this.
            _vidWidth;
        ENT_ld.
          _vidHeight =
          this.
            _vidHeight;
        ENT_ld.
          _fps =
          this.
            _fps;
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1470704446000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "YbBCRkNr0Qizk8jKtQw2ytNhrdoYTupWiXdbcB7qjAWHzjdXdZH3/CzlzkyP" +
       "heoYY5Bj2KCtcMERKyYUpgMTjZZ+Ua4X+nm7iSzpOE/nK15FcPS50jcHCK50" +
       "ivRq0CZMBWWCoe5WiUZ2OXQ6xfGyZSOjZaNd1Cly3lRBiIJFJA4iFzNanjlB" +
       "nQKkDqyx1ta5yJs3V3GZLFa5fCFbJsyY42tezl+0pblVW6AW6kkaUR7Pa0i9" +
       "VeKjaIi03LJnUQPg5XNNqjHsEo4xlexGTWB2jATVYbwASXSxz6ijBlJCdXw2" +
       "ayFUucCDODIX3LAPs4K4Wk6znX6Np5TynDQn3CwcD7LycpATpRxEymGez+f6" +
       "jTq8qmPZqKRgPin4JL1SSLzQ6NWRcbYp9ma02Bu3EbBmmZAhj5LIuDShojqJ" +
       "GcC8tCYUuHm7MpSdouaJdrPfnlYhwpm1zFI5C9VErhCxQWVADQC6T4dcI4et" +
       "GAQrqESRXpp14PIa71EL2CaVms63PHvVmNMjvazxUoDkbaFrWYto5Bpxzi1g" +
       "o3a2LLRXsqvP7Rhioml31c+uxkyNWihwYUjEMF/txS6KLFt5k1PrNQxMu11n" +
       "F9lxR2x66ARyIAGNBAQtiWBn+USy5Xz25W2F70x3+LtX4T/C3j6+4UnxgevT" +
       "fQch+w5uj+wc892v2MGWF9qBbilbeKd3uRIEni6GQXJhk5zEP3C9a/D01uGD" +
       "73jmOZn5ELyxfbKMBZmTgeP+pKlEirmvv1sAp8euf1DcTr8C2Dut/ew7vn1f" +
       "7/XaW17GNeZDh+Q8zPK32s9/nnhU+pWNzNHds9urvk842OjSwRPbU54ShJ7d" +
       "O3Bu+8DBK4HkqO7glcAR9uauBEBA2UzGX9gefyW9G3iTEgnmheRM5inBEq+k" +
       "BzPrHL/0A8Va550w2EqvPoML53hbcH0NDMPW1rnHN/dO2VLKixcvPb6pq5sX" +
       "DpVvvv6JTThXyiVdrrXcXF9d43ZyUqOsu2mSRPNym6njlzavbILpVa7HCsu/" +
       "BKc2WT/I6EbENDPcIX6S/5FvSz56w9uS37lB3e8lyW8HmdsPTE96Rrjnrc+/" +
       "nCuUtODDBy+hkxPMR7eFfvTwCeY+fa95fHlhDS03UOLTN6j7kyT5FPDcnmAo" +
       "g2QCrnkiFzm6vKfwH75ShcvgubSt8KX/H4WP7sHuk7tnuOtLzS/eQP8vJcln" +
       "9+ufFHxmT9fPvQJdU1g4dzUseDcHC4chOS2QHHe5hoedi8S16yV1prz5xKat" +
       "LDYPVF0AcJD4fgona7K1c+27TAHtAk339xddt0lyzbGfPnm/LnF6+7CfOi24" +
       "LvkaTPbTr0uu3UB1/V1SkE+ItqFkH9mlVwAcf31D4PjqDer+IUn+Ksic2Jmz" +
       "5P039szqKy/r2hXw2ZnS5KuIe6/6iHD94Zv0sedOn7jnuf7fpt/S7H6cdpLO" +
       "nFBD09x/A7kvf6vrKaqeSn1yfR+5HqtvBplj0Y5H/JN7jcvB9X1ofGRfsN/2" +
       "gVTHsy+l426T/V+8JAuE9FvKnWAerr+mvCx9/Dmq89SLxQ+tv7iRTGG1Sric" +
       "oDPH1x//7C4IHr4utx1etzYv/uCOT5x8ZGfxcsda4D0b2SfbQ9f+vAW33CD9" +
       "IGX1qXt+/3W/+dzX0muS/wPOd1AP5CoAAA==");
}
