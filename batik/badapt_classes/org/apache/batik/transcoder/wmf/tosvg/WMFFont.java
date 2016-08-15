package org.apache.batik.transcoder.wmf.tosvg;
public class WMFFont {
    public java.awt.Font font;
    public int charset;
    public int underline = 0;
    public int strikeOut = 0;
    public int italic = 0;
    public int weight = 0;
    public int orientation = 0;
    public int escape = 0;
    public WMFFont(java.awt.Font font, int charset) { super();
                                                      this.font = font;
                                                      this.charset = charset;
    }
    public WMFFont(java.awt.Font font, int charset, int underline, int strikeOut,
                   int italic,
                   int weight,
                   int orient,
                   int escape) { super();
                                 this.font = font;
                                 this.charset = charset;
                                 this.underline = underline;
                                 this.strikeOut = strikeOut;
                                 this.italic = italic;
                                 this.weight = weight;
                                 this.orientation = orient;
                                 this.escape = escape; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ye2wcxRmfO79f8SNxEpLYsZ0zKA9uCQUq6pSSGJs4XGwr" +
                                                              "Tlz1ArnM7c35Nt7b3ezO+s6mpoBASV9RCiEEBPkrKGkUCEKNStWCUqG2VIRK" +
                                                              "QFpKq4aqqtRUNCpRVfpIW/rN7N7t424vTf6opZ1bz37ffL/vm2++x5y6hGoM" +
                                                              "HXUThUbprEaM6JBCx7FukNSgjA1jO8wlxKer8F92XRy9M4xq42hBBhtbRWyQ" +
                                                              "YYnIKSOOuiTFoFgRiTFKSIpxjOvEIPoMppKqxFGnZIxkNVkSJbpVTRFGMIn1" +
                                                              "GGrHlOpS0qRkxF6Aoq4YIBE4EmGj//NADDWLqjbrkC91kQ+6vjDKrCPLoKgt" +
                                                              "tgfPYMGkkizEJIMO5HW0VlPl2SlZpVGSp9E98u22CbbEbi8xQd/LrZ9cOZhp" +
                                                              "4yZYiBVFpVw9YxsxVHmGpGKo1ZkdkknW2IseQlUx1OQipigSKwgVQKgAQgva" +
                                                              "OlSAvoUoZnZQ5erQwkq1msgAUdTrXUTDOs7ay4xzzLBCPbV158ygbU9RW0vL" +
                                                              "EhWfWiscenpX2ytVqDWOWiVlgsERAQQFIXEwKMkmiW5sTKVIKo7aFdjsCaJL" +
                                                              "WJbm7J3uMKQpBVMTtr9gFjZpakTnMh1bwT6CbropUlUvqpfmDmX/V5OW8RTo" +
                                                              "utjR1dJwmM2Dgo0SANPTGPzOZqmelpQURSv9HEUdI/cBAbDWZQnNqEVR1QqG" +
                                                              "CdRhuYiMlSlhAlxPmQLSGhUcUKdoWeCizNYaFqfxFEkwj/TRjVufgKqBG4Kx" +
                                                              "UNTpJ+MrwS4t8+2Sa38ujW448KCyWQmjEGBOEVFm+JuAqdvHtI2kiU7gHFiM" +
                                                              "zWtih/Hi1/aHEQLiTh+xRfPdL1++e1332TctmuVlaMaSe4hIE+Kx5IJ3Vgyu" +
                                                              "vrOKwajXVENim+/RnJ+ycfvLQF6DCLO4uCL7GC18PLvtx196+CT5KIwaR1Ct" +
                                                              "qMpmFvyoXVSzmiQT/V6iEB1TkhpBDURJDfLvI6gO3mOSQqzZsXTaIHQEVct8" +
                                                              "qlbl/4OJ0rAEM1EjvEtKWi28a5hm+HteQwjVwYOa4elC1h//pWi3kFGzRMAi" +
                                                              "ViRFFcZ1lelvCBBxkmDbjJAEr58WDNXUwQUFVZ8SMPhBhtgfqI4VQ4QgpAu5" +
                                                              "bFqgqjEzJXxx6/AwGCvKPE37P8jIMz0X5kIh2IIV/gAgw9nZrMrAnRAPmZuG" +
                                                              "Lr+UeMtyLnYgbAtRdDOIjVpio1xs1BEbBbFRLjZqi0WhEJe2iIm3Nhu2ahoO" +
                                                              "PUTd5tUTD2zZvb+vCrxMy1WDncNA2ufJPoNOZCiE84R4uqNlrvfC+jfCqDqG" +
                                                              "OrBITSyzZLJRn4IwJU7bJ7k5CXnJSQ89rvTA8pquiiQF0SkoTdir1KszRGfz" +
                                                              "FC1yrVBIXuyYCsGpoyx+dPZI7pHJr9wSRmFvRmAiayCYMfZxFseL8TrijwTl" +
                                                              "1m3dd/GT04fnVScmeFJMITOWcDId+vz+4DdPQlzTg88kXpuPcLM3QMymGM4Y" +
                                                              "hMNuvwxPyBkohG+mSz0onFb1LJbZp4KNG2lGV3PODHfUdv6+CNyiiZ3BDnhu" +
                                                              "sg8l/2VfF2tsXGI5NvMznxY8PXx+Qnv+lz/742e4uQuZpNVVAkwQOuCKXmyx" +
                                                              "Dh6n2h233a4TAnS/OTL+5FOX9u3kPgsUq8oJjLBxEKIWbCGY+fE3937w4YVj" +
                                                              "58NFPw9RSN9mEqqgfFFJNo8aKygJ0m508ED0kyE6MK+J7FDAP6W0hJMyYQfr" +
                                                              "X63968/86UCb5QcyzBTcaN3VF3Dmb9iEHn5r19+6+TIhkWVfx2YOmRXSFzor" +
                                                              "b9R1PMtw5B95t+uZn+DnITlAQDakOcJjbNg+6wzUUopaOCfO0SiLGN4IwE7Z" +
                                                              "hJk04LRKWdicGTuJ3Tq+W9wfGf+9laBuKMNg0XWeEL45+f6ec3zr61k8YPNM" +
                                                              "cIvrtEPccPldm7Uln8JfCJ7/sIdtBZuwkkHHoJ2ReoopSdPygHx1hRrSq4Aw" +
                                                              "3/Hh9HMXX7QU8KdsHzHZf+hrn0YPHLL206prVpWUFm4eq7ax1GHDAEPXW0kK" +
                                                              "5xj+w+n575+Y32eh6vBm6SEoQl/8xb/PRY/89qdlEkOVZNemtzEHt9ycnUjv" +
                                                              "3lgK3fPV1h8c7KgahkgygupNRdprkpGUe0Uoywwz6dosp17iE27V2MZAplkD" +
                                                              "e8Cnb+cwbimCQRwM4t+2sKHfcAdU71a5Ku+EePD8xy2TH79+mavrLd3d8WMr" +
                                                              "1ixbt7PhRmbrJf6EtxkbGaC77ezo/W3y2SuwYhxWFCGRG2M65M68J9rY1DV1" +
                                                              "v/rhG4t3v1OFwsOoUVZxahjzwI0aIGISIwP5Oq994W4rYOTqYWjjqqIS5Usm" +
                                                              "2KFdWT4cDGU1yg/w3KtLvrPh+NELPHJpfImu0qi8zg5Y68pHZTbexIa1pbEu" +
                                                              "iNW3g/Uccz379w42fK7ywAXHK3jB/WzYwT/dx4ZJyzyj12lJNrFdsz4st6Cy" +
                                                              "CstTyPD+2MmlJ9/77M+Pf+twzjppFeKGj2/pP8fk5KO/+3uJR/LSoUwo8fHH" +
                                                              "hVPPLRu86yPO7+Rwxh3Jl1aFUAc5vLeezP413Ff7ozCqi6M20e5HJ7FssswY" +
                                                              "hx7MKDSp0LN6vnv7Kat5GCjWKCv8scwl1l89uENENfWEA1/B0AlPt+1f3X7X" +
                                                              "DCH+kqnonUHcFLoJsFzRHRc6niRdzZOSXpBL4Flpi1kZAFKtCDKIm6I6McO6" +
                                                              "elo8GC6c2jXiZG1Qjy2pJwDnTEWcQdwUNZgKBEDWr5VDmrsOpL22rN4ApPMV" +
                                                              "kQZxA1KonKVpMmaWtelD14h0GTx9tqy+AKSPVUQaxA3lpUQxlJflYD5+HTBX" +
                                                              "2YJWBcD8ekWYQdwAM0ekqUxZa37jGmEy/4/YgiIBMJ+oCDOIm6ImVZcgmuNC" +
                                                              "d+DH+uR1mLTfltYfgPWZiliDuMGkxBCxVvYoPVsBZr6cOP5Xi3y3IS5xrpSH" +
                                                              "WNnTFXRhxcvLY48eOpoae2F92E7Dm+BEUVW7WSYzRPYsBcHLvkFgZcrSkstK" +
                                                              "64JNfOloa/2Sozve5x1p8RKsGUr9tCnL7kzheq/VdJKWOIBmK29o/OfbFPX/" +
                                                              "T5cbFNXwX474hMV8iqKVV2GGEhlGN9NpipZXYKLQFxf/cfO9QlGbnw9A8V83" +
                                                              "3RlYwaED17Be3CSvAiogYa/f0wodWRsvC1mqjlqpOh/ybnTRozqv5vgu31jl" +
                                                              "KXL4NXWhMTCti+qEeProltEHL9/xgtWqizKem2OrNEE7YN0aFC9EegNXK6xV" +
                                                              "u3n1lQUvN/QXvK3dAuycieWuinA7dCsa87Vlvj7WiBTb2Q+ObXj97f2170Lt" +
                                                              "tBOFMEULd5YWNXnNhGOwM1ba9kBRwxvsgdXPzt61Lv3nX/OqGllt0opg+oR4" +
                                                              "/vgD7z2x9Bg04k0jqAYOEsnzauueWWUbEWf0OGqRjKE8QIRVJCx7eqoF7Fhg" +
                                                              "doHN7WKbs6U4yy56KOorbSdLr8egA8kRfZMK+ZotA11ZkzPjuT+3j1qjqWk+" +
                                                              "BmfG1XIPs2Egz3YD/DER26pphW676R8aDzX3+ntLPsm5z/FXNrz9X3AxnKDC" +
                                                              "GgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
