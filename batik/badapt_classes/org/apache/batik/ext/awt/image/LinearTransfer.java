package org.apache.batik.ext.awt.image;
public class LinearTransfer implements org.apache.batik.ext.awt.image.TransferFunction {
    public byte[] lutData;
    public float slope;
    public float intercept;
    public LinearTransfer(float slope, float intercept) { super();
                                                          this.slope = slope;
                                                          this.intercept =
                                                            intercept; }
    private void buildLutData() { lutData = (new byte[256]);
                                  int j;
                                  int value;
                                  float scaledInt = intercept * 255.0F + 0.5F;
                                  for (j = 0; j <= 255; j++) { value = (int)
                                                                         (slope *
                                                                            j +
                                                                            scaledInt);
                                                               if (value <
                                                                     0) {
                                                                   value =
                                                                     0;
                                                               }
                                                               else
                                                                   if (value >
                                                                         255) {
                                                                       value =
                                                                         255;
                                                                   }
                                                               lutData[j] =
                                                                 (byte)
                                                                   (255 &
                                                                      value);
                                  } }
    public byte[] getLookupTable() { buildLutData();
                                     return lutData; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1ZaYwcxRWunV3vvd7DJz7Wx64BG3sGCJe1Dthe7+I1Y3vl" +
                                                              "NStlDaxremp229vT3e6u3p01cTgkZOeyiGPAifD+SEzsEGMjKyhEHHGEYkAQ" +
                                                              "Eo6EEATkUkJCULCikChOQt6r6p4+5rBQIkbqmp6q96ree/Xe917VnHifTLMt" +
                                                              "0s50HueTJrPjPTrvp5bN0t0ate3t0DesPFBJ/3rbu1tWx0j1EJk+Su3NCrVZ" +
                                                              "r8q0tD1EFqq6zamuMHsLY2nk6LeYzaxxylVDHyKzVLsva2qqovLNRpohwSC1" +
                                                              "kqSVcm6pKYezPncCThYmQZKEkCSxLjrclSSNimFO+uRzA+TdgRGkzPpr2Zy0" +
                                                              "JHfRcZpwuKolkqrNu3IWucw0tMkRzeBxluPxXdrVrgk2Ja8uMMHSR5s/PH/v" +
                                                              "aIswwQyq6wYX6tnbmG1o4yydJM1+b4/GsvZu8jlSmSQNAWJOOpPeoglYNAGL" +
                                                              "etr6VCB9E9OdbLch1OHeTNWmggJxsiQ8iUktmnWn6Rcywwy13NVdMIO2i/Pa" +
                                                              "Si0LVLzvssShB25rOV1JmodIs6oPoDgKCMFhkSEwKMummGWvS6dZeoi06rDZ" +
                                                              "A8xSqabucXe6zVZHdMod2H7PLNjpmMwSa/q2gn0E3SxH4YaVVy8jHMr9NS2j" +
                                                              "0RHQdbavq9SwF/tBwXoVBLMyFPzOZakaU/U0J4uiHHkdO28CAmCtyTI+auSX" +
                                                              "qtIpdJA26SIa1UcSA+B6+giQTjPAAS1O5pWcFG1tUmWMjrBh9MgIXb8cAqo6" +
                                                              "YQhk4WRWlEzMBLs0L7JLgf15f8uaA7frG/UYqQCZ00zRUP4GYGqPMG1jGWYx" +
                                                              "iAPJ2LgieT+d/dT+GCFAPCtCLGm+99lza1e2n3lO0swvQrM1tYspfFg5mpr+" +
                                                              "8oLu5asrUYxa07BV3PyQ5iLK+t2RrpwJCDM7PyMOxr3BM9vOfubOh9l7MVLf" +
                                                              "R6oVQ3Oy4EetipE1VY1ZNzKdWZSzdB+pY3q6W4z3kRp4T6o6k71bMxmb8T5S" +
                                                              "pYmuakP8BhNlYAo0UT28q3rG8N5NykfFe84khNTAQ66FZxGRH/HNyc7EqJFl" +
                                                              "CapQXdWNRL9loP52AhAnBbYdTaTA68cStuFY4IIJwxpJUPCDUeYOYGTSCZ5Q" +
                                                              "s7D9CRSXWtstqtuwN3H0NPMTWCOHes6YqKiALVgQBQANYmejoaWZNawcctb3" +
                                                              "nDs5/IJ0LgwI10KcrIJl43LZuFhWwCUsGxfLxsPLkooKsdpMXF5uNhCMQdAD" +
                                                              "6jYuH7h10879SyvBy8yJKrAzki4NZZ9uHxk8OB9WTrU17Vny9hXPxEhVkrRR" +
                                                              "hTtUw2SyzhoBmFLG3EhuTEFe8tPD4kB6wLxmGQpLAzqVShPuLLXGOLOwn5OZ" +
                                                              "gRm85IVhmiidOorKT84cnrhr8I7LYyQWzgi45DQAM2TvRxzP43VnFAmKzdu8" +
                                                              "790PT92/1/AxIZRivMxYwIk6LI36Q9Q8w8qKxfSx4af2dgqz1wFmcwqbDXDY" +
                                                              "Hl0jBDldHnyjLrWgcMawslTDIc/G9XzUMib8HuGoreJ9JrhFA8bgRfBc6Qal" +
                                                              "+MbR2Sa2c6Rjo59FtBDp4dMD5pFfvPTHTwlze5mkOVACDDDeFUAvnKxN4FSr" +
                                                              "77bbLcaA7q3D/V+97/19O4TPAkVHsQU7se0G1IItBDPf89zuN955++hrMd/P" +
                                                              "OaRvJwVVUC6vJPaT+jJKwmoX+/IA+mmADug1nTfr4J9qRqUpjWFg/at52RWP" +
                                                              "/flAi/QDDXo8N1p54Qn8/ovWkztfuO3v7WKaCgWzr28zn0xC+gx/5nWWRSdR" +
                                                              "jtxdryz82rP0CCQHAGRb3cMExsaEDWLhWMd4GnBSNsSlmoVtGHfT1ZX9O5X9" +
                                                              "nf2/k6nooiIMkm7W8cSXB1/f9aLY5FqMfOxHvZsCcQ0IEfCwFmn8j+BTAc9/" +
                                                              "8EGjY4eE/bZuN/cszicf08yB5MvLVIthBRJ7294Ze/DdR6QC0eQcIWb7D33h" +
                                                              "o/iBQ3LnZAXTUVBEBHlkFSPVwWY1Srek3CqCo/cPp/Y+cXzvPilVWzgf90C5" +
                                                              "+cjP//1i/PCvni+SAiCEDCrr0KvQmfPQPTO8O1KlDZ9vfvLetspeQI0+Uuvo" +
                                                              "6m6H9aWDc0IJZjupwHb5tZHoCCqHW8NJxQrYBey4TrRXC1kuz0tEhEREjG3E" +
                                                              "ZpkdRNDwjgVK7WHl3tc+aBr84OlzQutwrR4EjM3UlCZvxeZiNPmcaIbbSO1R" +
                                                              "oLvqzJZbWrQz52HGIZhRgcxtb7Ugy+ZC8OJST6v55Q+fmb3z5UoS6yX1YOZ0" +
                                                              "LxVITeoAIpk9Cgk6Z96wViLERC00LUJVUqB8QQdG6aLi8d+TNbmI2D2Pz/nu" +
                                                              "mmNTbwuoMuUc8wV/JdYModQsTnx+dnj41Wt/duwr909IjyoTHxG+uf/cqqXu" +
                                                              "/s0/CkwukmGRkInwDyVOPDiv+/r3BL+flZC7M1dY50Bm93mvfDj7t9jS6h/F" +
                                                              "SM0QaVHcE9Yg1RzE+iE4VdjesQtOYaHx8AlBlsNd+ay7IBqzgWWj+TAYCFU8" +
                                                              "5PSRFDgfng43O3REU2AFES9DguUSbC4rzC2luDmp0Ry+gXIaPv/nQVZgugzo" +
                                                              "WxrO/sD+5u9Py40uBuGRE8fxY7XKm9mzAsJxtWvzci1AMRYDeDwpxZLfnCj/" +
                                                              "YyWcstQ0lMDrIQsMKJZqcji+9ejjqmXoWZTXLbg/iWUQG5aVDoaAXae+1fHS" +
                                                              "HVMdvxZIUava4DKQroqcAgM8H5x4571XmhaeFCVZFWY9F0LDx+fC03Ho0Ct2" +
                                                              "pRmblAz5a9xMgl9dgfcbOCwyyVkU+/FnDwCGSYqPyPIM2z5sdsjZkiVxbHvY" +
                                                              "7+fAc6nruZeW8HuzrN+X4oZkZmuGDLnrIlLu/phSYnSuctdZVULKibJSluLm" +
                                                              "pE5soMJMXkzSXBlJc8VWFJ9qEjnlBmtNH/grxPtcThIXOPl5Z75eRxdpBT1/" +
                                                              "YakLDFGEHL370FR660NXeMCwFhTlhrlKY+NMC4iApeLCUO7ZLLzXB/K3ph/8" +
                                                              "7fc7R9Z/nBMh9rVf4MyHvxdBCK4oHcFRUZ69+0/ztl8/uvNjHO4WRawUnfLb" +
                                                              "m088f+PFysGYuJ+SGabgXivM1BXOK/UW446lh0uqjrw/NHo+0OX6Q1fUf32P" +
                                                              "u0S0K7BZ5R1makxLHYfiOHKaaSgzY5mS7WCZsUPYfJHDTjqqlk66OasYTo0b" +
                                                              "atoPkS9dKJjLl07YsU1CzL68jjNwbAk8g66Og2WsViLkS7GWMcE3yowdxeYI" +
                                                              "J9NHGE8axphjbsczHfZS3xhT/w9j5GCV8GUPFphzC+6V5V2ocnKquXbO1M2v" +
                                                              "y0zl3Vc2QqxlHE0LlkCB92rTYhlVaNYoCyJZ9p/gpL08GgGwi28h/Xck1ylO" +
                                                              "5pbi4qQS2iD1aU5mFqMGSmiDlI9x0hKlhPXFd5DucU7qfTpOquVLkOQJmB1I" +
                                                              "8PVJ0wPeFlG0Y50Zl3VmriIAju4OiY2ddaGNzbMEby7QBOJfAw9+HPm/wbBy" +
                                                              "amrTltvPXfOQvDlRNLpnD87SAPWDvMTJQ9iSkrN5c1VvXH5++qN1yzywb5UC" +
                                                              "+yEyP+DH2wBWTPSneZFrBbszf7vwxtE1T/94f/UrUC/tIBWUkxk7CivynOlA" +
                                                              "7tiRLDyZAtyL+46u5V+fvH5l5i9vijMPkSfZBaXph5XXjt366sG5R9tjpKEP" +
                                                              "3ExPs5w4KmyY1LcxZdwaIk2q3ZMDEWEWlWqhY+90dH2K/ycIu7jmbMr34r0b" +
                                                              "J0sLz/yFt5VwPpxg1nrD0dMC1CHd+D2hvzO8LOCYZoTB7wmUghsklOJugD8O" +
                                                              "JzebpnclUneTKeK/p3Sh9xPxis1P/wtXHtwOURwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
