package org.apache.batik.gvt.event;
public class SelectionEvent {
    public static final int SELECTION_CHANGED = 1;
    public static final int SELECTION_CLEARED = 3;
    public static final int SELECTION_STARTED = 4;
    public static final int SELECTION_DONE = 2;
    protected java.awt.Shape highlightShape;
    protected java.lang.Object selection;
    protected int id;
    public SelectionEvent(java.lang.Object selection, int id, java.awt.Shape highlightShape) {
        super(
          );
        this.
          id =
          id;
        this.
          selection =
          selection;
        this.
          highlightShape =
          highlightShape;
    }
    public java.awt.Shape getHighlightShape() { return highlightShape;
    }
    public java.lang.Object getSelection() { return selection; }
    public int getID() { return id; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVZe2wUxxkfn41tjN+8XwaMoTKQu0AhNBhojLHB9PyQ7Vit" +
                                                              "STiv9+buFu/tLrtz9kFKGpAaSKtSSnm1SlD/cARBEKKq9JlEtKglKGlVElqa" +
                                                              "VJAorVTaFDW0alKVtun3ze7dPu5BjZqTdm5vZr755vd933y/mbkzt8gEQyd1" +
                                                              "VGF+tlOjhr9VYd2CbtBwiywYRh/UhcRjhcLftt3sfNBHigdIZUwwOkTBoG0S" +
                                                              "lcPGAJkrKQYTFJEanZSGUaJbpwbVRwQmqcoAmSoZ7XFNlkSJdahhih36BT1I" +
                                                              "agTGdGkowWi7NQAjc4MwkwCfSaDZ29wUJOWiqu20u89wdG9xtGDPuK3LYKQ6" +
                                                              "uF0YEQIJJsmBoGSwpqROlmqqvDMqq8xPk8y/XV5lmWBLcFWGCepfqPrgzsFY" +
                                                              "NTfBZEFRVMbhGT3UUOURGg6SKru2VaZxYwd5nBQGySRHZ0YagimlAVAaAKUp" +
                                                              "tHYvmH0FVRLxFpXDYamRijURJ8TIAvcgmqALcWuYbj5nGKGUWdi5MKCdn0Zr" +
                                                              "osyAeGRp4PCxbdXfLiRVA6RKUnpxOiJMgoGSATAojQ9R3WgOh2l4gNQo4Oxe" +
                                                              "qkuCLO2yPF1rSFFFYAlwf8osWJnQqM512rYCPwI2PSEyVU/Di/CAsn5NiMhC" +
                                                              "FLBOs7GaCNuwHgCWSTAxPSJA3FkiRcOSEmZknlcijbHhM9ABREvilMXUtKoi" +
                                                              "RYAKUmuGiCwo0UAvhJ4Sha4TVAhAnZFZOQdFW2uCOCxEaQgj0tOv22yCXhO5" +
                                                              "IVCEkanebnwk8NIsj5cc/rnVufbAY8pmxUcKYM5hKso4/0kgVOcR6qERqlNY" +
                                                              "B6Zg+ZLgUWHaS/t9hEDnqZ7OZp/vff72Q8vqLrxi9pmdpU/X0HYqspA4NlR5" +
                                                              "ZU5L44OFOI1STTUkdL4LOV9l3VZLU1KDDDMtPSI2+lONF3p+9rknTtP3fKSs" +
                                                              "nRSLqpyIQxzViGpck2Sqb6IK1QVGw+1kIlXCLby9nZTAe1BSqFnbFYkYlLWT" +
                                                              "IplXFav8N5goAkOgicrgXVIiaupdE1iMvyc1QkgJPKQcnjpifvg3I48EYmqc" +
                                                              "BgRRUCRFDXTrKuI3ApBxhsC2scAQRP1wwFATOoRgQNWjAQHiIEathugIrM4R" +
                                                              "zE+9VAZJTAv4049Rpn3M4ycR3+TRggIw/RzvwpdhzWxW5TDVQ+LhxIbW28+H" +
                                                              "XjWDCheCZRlGGkGl31Tp5yr9oNLPVfrdKklBAdc0BVWbDgb3DMNCh0xb3tj7" +
                                                              "6JbB/fWFEFnaaBHYFrvWuxinxc4GqRQeEs/VVuxacGP5RR8pCpJaQWQJQUYC" +
                                                              "adajkJrEYWv1lg8BF9mUMN9BCchluirSMGSkXNRgjVKqjlAd6xmZ4hghRVi4" +
                                                              "NAO56SLr/MmF46N7+r9wv4/43CyAKidAAkPxbszd6Rzd4F392cat2nfzg3NH" +
                                                              "d6t2HnDRSooNMyQRQ703FrzmCYlL5gvnQy/tbuBmnwh5mgmwriAF1nl1uNJM" +
                                                              "UyplI5ZSABxR9bggY1PKxmUspqujdg0P0hr+PgXCYhKuu5nwtFoLkX9j6zQN" +
                                                              "y+lmUGOceVBwSljXqz3zm1/88ZPc3Cn2qHLQfi9lTY6MhYPV8txUY4dtn04p" +
                                                              "9Lt+vPvrR27t28pjFnoszKawAcsWyFTgQjDzF1/Z8ebbN8au+uw4Z0DZiSHY" +
                                                              "+STTILGelOUBCdoW2/OBjGctNKPhYQXiU4pIwpBMcWH9q2rR8vN/PlBtxoEM" +
                                                              "NakwWnb3Aez6mRvIE69u+7COD1MgIuPaNrO7mWl8sj1ys64LO3EeyT2vz/3G" +
                                                              "JeEZIARIwoa0i/K8WshtUMiRz4ANGJdEcvWbTOJOArjQehNDBixYKQ7+GbG4" +
                                                              "a0X3oLi/ofv3Ji/NzCJg9pt6KvCV/mvbX+PeL8WUgPWou8Kx4CF1OEKv2vTK" +
                                                              "R/ApgOc/+KA3sMLkgNoWi4jmp5lI05Iw88Y8W0c3gMDu2reHn7551gTgZWpP" +
                                                              "Z7r/8Jc+8h84bLrU3M4szNhROGXMLY0JB4smnN2CfFq4RNsfzu3+0and+8xZ" +
                                                              "1brJuRX2nmd//e/X/MffuZyFFwola0u6EmM8ndGnuH1jAtr4VNWLB2sL2yCZ" +
                                                              "tJPShCLtSND2sHNE2I0ZiSGHs+xtEq9wQkPHANksQR9YYVXJw0oYBUqKCRrl" +
                                                              "vVfxxvvTcyR8joS3BbFYZDhTrduDjn14SDx49f2K/vdfvs2t4N7IOzNLh6CZ" +
                                                              "LqjBYjG6YLqXCjcLRgz6rbzQ+Ui1fOEOjDgAI4pA7UaXDlScdOUhq/eEkrd+" +
                                                              "fHHa4JVC4msjZbIqhNsEntLJRMil1IgBiye1Tz9kppLRUiiqOVSSAT6jApfz" +
                                                              "vOyJojWuMb60d31/+nfWnjxxg+c0y+izuXwJbixcHM6PgzaNnH5j9a9Ofu3o" +
                                                              "qBlhedaLR27GP7vkob3v/iPD5Jw1sywhj/xA4MzTs1rWv8flbfpC6YZk5mYI" +
                                                              "tgC27IrT8b/76ot/6iMlA6RatI5f/YKcQFIYgCOHkTqTwRHN1e4+PpgZrilN" +
                                                              "z3O8a9ih1kuczqVRxFzLwObKGejCFfA0WDTS4OVKviGrsZNuO5yWolSvffdb" +
                                                              "Yx/u2fcpHybrCSM4dbCKIzl3JvCU9+SZI3MnHX7ny9zxuMBx0G1c/Sd4uQSL" +
                                                              "+8wUj69+4DqDHxgZwJEUQfZw3vQ8k2Wkprc12NrS197VGWrZ3Ny5qXUjNqwx" +
                                                              "CR/LDixC5pjdOQP+s5kGarR0NmYxEL4MphAM50OHBXdEJAusXCrcsIKtzT3Z" +
                                                              "Ycn3AMtv6fTngVWEL+yeYeVS4YLV29fc05cdVmKcsALwrLR0rswDy4cvu+8Z" +
                                                              "Vi4VwCU2rI1dna3ZMD3+v2OqxNqF8Ky2FK7OwET4y5PZocDucaKmqwwSCQ17" +
                                                              "cFTkGRZwxKRoTIaHcU7E2nYPjn3jxDEPnjWWwjU5cHzVxIHFU5nTzSUNKI3U" +
                                                              "YRIrHvDM9OA4ZzoVnnWWrnU5Zno070xzSTPik8LZguJYnikmbVVL06r4p5h4" +
                                                              "rhwcqhxES3A3MTfXrRDfzI3tPXwi3PXscp+1x9kANmWqdp8MZ3XZMVQhjuTi" +
                                                              "7A5+D2YT4PXKQ7/7QUN0w3iO3FhXd5dDNf6eBzyzJPc2wDuVS3v/NKtvfWxw" +
                                                              "HKfneR4reYd8ruPM5U2LxUM+fulnMnPGZaFbqMnNx2U6ZQldcW9OF6b9WoP+" +
                                                              "qoen0/JrpzcA7cjxhET6XJhLNM+e9myetnNYnIKUHaVsc2ZasIP4ubuts/yb" +
                                                              "Sazo13j9WBpUbSq2+y1Q/eO3Ry7RPJh/mKftRSzOM1IO9uh15R3bFN/9GExR" +
                                                              "hW34MmjhGRy/KXKJ5oF7KU/bZSx+Ats1MEW7yeC2DS7+P2yQRE513RTioWNG" +
                                                              "xh8R5uW5+PyJqtLpJx6+xrNP+oK7HPJIJCHLzm2x471Y02lE4oDKzU2yxr+u" +
                                                              "MDIr9wUmoObffOa/NCWuMjIlmwSceKF09rzGSLW3J4zIv5393mKkzO4HO2Tz" +
                                                              "xdnlOowOXfD1hpbzriRZ4GaEtJum3s1NDhJZ6Eq+/E+jVKJMmH8bhcRzJ7Z0" +
                                                              "Pnb7gWfNSzRRFnbtwlEmwSndvM9LJ9sFOUdLjVW8ufFO5QsTF6VoqcacsB3n" +
                                                              "sx3BCMu7QMPomOW5YTIa0hdNb46tffnn+4tfh7PLVlIgMDJ5a+aZK6klgOW2" +
                                                              "BjNvI4CY+NVXU+M3d65fFvnLb9OHG/dZ1ts/JF49+egbh2aM1fnIJDg0AePS" +
                                                              "JD8Mbtyp9FBxRB8gFZLRmoQpwiiSILuuOioxkAX8O4nbxTJnRboWr2AZqc+8" +
                                                              "5cm8uC6T1VGqb1ATCt+HVAAx2jWuf7NSfJXQNI+AXeO4CWvDoimJ3oB4DAU7" +
                                                              "NC11CeZTNL6aN3mvfHgll77NX7H4638BM9s+w1AeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "YPfzb/sv7/uJV79cfsf7O3jcc7DaKAAA");
}
