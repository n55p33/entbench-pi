package org.apache.batik.parser;
public class FloatArrayProducer extends org.apache.batik.parser.DefaultNumberListHandler implements org.apache.batik.parser.PointsHandler {
    protected java.util.LinkedList as;
    protected float[] a;
    protected int index;
    protected int count;
    public float[] getFloatArray() { return a; }
    public void startNumberList() throws org.apache.batik.parser.ParseException {
        as =
          new java.util.LinkedList(
            );
        a =
          (new float[11]);
        count =
          0;
        index =
          0;
    }
    public void numberValue(float v) throws org.apache.batik.parser.ParseException {
        if (index ==
              a.
                length) {
            as.
              add(
                a);
            a =
              (new float[a.
                           length *
                           2 +
                           1]);
            index =
              0;
        }
        a[index++] =
          v;
        count++;
    }
    public void endNumberList() throws org.apache.batik.parser.ParseException {
        float[] all =
          new float[count];
        int pos =
          0;
        java.util.Iterator it =
          as.
          iterator(
            );
        while (it.
                 hasNext(
                   )) {
            float[] b =
              (float[])
                it.
                next(
                  );
            java.lang.System.
              arraycopy(
                b,
                0,
                all,
                pos,
                b.
                  length);
            pos +=
              b.
                length;
        }
        java.lang.System.
          arraycopy(
            a,
            0,
            all,
            pos,
            index);
        as.
          clear(
            );
        a =
          all;
    }
    public void startPoints() throws org.apache.batik.parser.ParseException {
        startNumberList(
          );
    }
    public void point(float x, float y) throws org.apache.batik.parser.ParseException {
        numberValue(
          x);
        numberValue(
          y);
    }
    public void endPoints() throws org.apache.batik.parser.ParseException {
        endNumberList(
          );
    }
    public FloatArrayProducer() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+T6DR3EydF8U4ZdhSXw7/78LPDsYhSUAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV6e+zr1n2fftf29dv32m5sz41f8bVTh92lKEoiFTet9SAl" +
       "kZRIidSD3Bybb1KkSIoPiWTmpjXWJliHLGidNAMa/zGkexRuUnQrumJo56Ho" +
       "I2jRLUXQvZusG9B0aYYEW7ui2ZYdUr/3fTiJXQE8OuT5nnO+z8/58vC88bXK" +
       "bVFYgQLfzUzXj6/qaXx15TauxlmgR1cppsHJYaRrXVeOIgE8e0l9zy9c+vNv" +
       "fty6fKFyUao8KHueH8ux7XvRVI98d6trTOXSyVPC1ddRXLnMrOStDCex7cKM" +
       "HcXPM5W7T3WNK1eYIxZgwAIMWIBLFuD2CRXodK/uJetu0UP24mhT+eHKAVO5" +
       "GKgFe3HlqbODBHIorw+H4UoJwAh3FPdzIFTZOQ0rTx7Lvpf5GoE/AcGv/fQH" +
       "L//iLZVLUuWS7fEFOypgIgaTSJV71vpa0cOorWm6JlXu93Rd4/XQll07L/mW" +
       "Kg9EtunJcRLqx0oqHiaBHpZznmjuHrWQLUzU2A+PxTNs3dWO7m4zXNkEsj50" +
       "IuteQrJ4DgS8ywaMhYas6kddbnVsT4srT5zvcSzjFRoQgK63r/XY8o+nutWT" +
       "wYPKA3vbubJnwnwc2p4JSG/zEzBLXHn0hoMWug5k1ZFN/aW48sh5Om7fBKju" +
       "LBVRdIkr7zpPVo4ErPToOSudss/Xxj/wsQ95A+9CybOmq27B/x2g0+PnOk11" +
       "Qw91T9X3He95H/NJ+aFf/eiFSgUQv+sc8Z7ml//WN174/sff/O09zfdeh4ZV" +
       "Vroav6R+RrnvC+/uPte6pWDjjsCP7ML4ZyQv3Z87bHk+DUDkPXQ8YtF49ajx" +
       "zelvij/yc/pXL1TuGlYuqr6brIEf3a/668B29bCve3oox7o2rNype1q3bB9W" +
       "bgd1xvb0/VPWMCI9HlZudctHF/3yHqjIAEMUKrod1G3P8I/qgRxbZT0NKpXK" +
       "7eCqPAmupyr73xNFEVdehC1/rcOyKnu258Nc6BfyR7DuxQrQrQUrwOsdOPKT" +
       "ELgg7IcmLAM/sPTDhqCIrxC4qy/H7TCUMzCClqh6eLVws+CveoK0kPDy7uAA" +
       "KP/d50PfBVEz8F1ND19SX0s6xDc++9LvXDgOhUPdxJX3gTmv7ue8Ws55dT/n" +
       "1WvnrBwclFN9TzH33sbAQg6IdYCC9zzHv0i9/NH33AKcK9jdCtRbkMI3BuPu" +
       "CToMSwxUgYtW3vzU7kfnH65eqFw4i6oFv+DRXUV3rsDCY8y7cj6arjfupY98" +
       "5c8/98lX/JO4OgPTh+F+bc8iXN9zXrOhr+oaAMCT4d/3pPxLL/3qK1cuVG4F" +
       "GABwL5aBnwJIefz8HGfC9vkjCCxkuQ0IbPjhWnaLpiPcuiu2Qn938qQ0+X1l" +
       "/f4jf37qlGOX/0Xrg0FRfs/eRQqjnZOihNgP8MGn/93v/QlaqvsIjS+dWt94" +
       "PX7+FAIUg10qY/3+Ex8QQl0HdP/5U9xPfeJrH/kbpQMAiqevN+GVouyCyAcm" +
       "BGr+sd/e/Psv/eFnvnjhxGlisAQmimur6V7Ib4HfAbj+X3EVwhUP9tH7QPcQ" +
       "Qp48xpCgmPnZE94Amrgg4AoPujLz1r5mG7asuHrhsf/n0jPIL/3pxy7vfcIF" +
       "T45c6vvfeoCT53+tU/mR3/ng/368HOZALVazE/2dkO0h8sGTkcvQKvhIf/T3" +
       "H/v7vyV/GoAtALjIzvUSsyqlPiqlAaulLqCyhM+11Yriieh0IJyNtVNZx0vq" +
       "x7/49XvnX/+1b5Tcnk1bTtt9JAfP712tKJ5MwfAPn4/6gRxZgK7+5vhvXnbf" +
       "/CYYUQIjqgDHIjYEsJOe8ZJD6ttu/w//6tcfevkLt1QukJW7AMRopFwGXOVO" +
       "4Ol6ZAHESoMfemHvzbs7QHG5FLVyjfB7B3mkvLsdMPjcjbGGLLKOk3B95C9Z" +
       "V3n1j/7iGiWUKHOdxfZcfwl+42ce7f7gV8v+J+Fe9H48vRaKQYZ20rf2c+s/" +
       "u/Cei79xoXK7VLmsHqZ/c9lNiiCSQMoTHeWEIEU80342fdmv1c8fw9m7z0PN" +
       "qWnPA83JEgDqBXVRv+scttxXaPnd4Hr2EFuePY8tB5Wy8kLZ5amyvFIU7z0K" +
       "5TuD0I8Bl7pWjv1cXLkAUp2w8tQNTDWVd2Uy9JL6K5Mvf+HT+efe2AenIoPV" +
       "vgLdKK++NrUvcPuZm6w9JxnXn/Xf/+af/Nf5ixcOw+nus/I/cjP5S9J3xddf" +
       "EIs2eo++RYkWRXvfpXlD/37+2tmhw9mhG2ifvYH2i2rvSO0HcnRThZRgtFfI" +
       "6//w6d/78OtP/5cynu+wI+BG7dC8Ttp6qs/X3/jSV3//3sc+W65/pbVKhzqf" +
       "71+bzp/J0ktm7znWwKNHidp7DzXw3j3sL95mTgW6rQtg9sM2qJWBf5Su/VUN" +
       "nd4cnrjQXoP1dXuYy8OvPPAl52e+8vP7PP08Fp0j1j/62t/51tWPvXbh1NvR" +
       "09e8oJzus39DKpV9b+ke6ZmIvM4sZQ/yjz/3yr/4x698ZM/VA2dzfQK8yv78" +
       "H/zf3736qS9//jpJJgAfkEweI/jBYX5YenxRLI6cWb2+M18oqt9XjGN7snvk" +
       "1Bdd3TNjqySWDiUp/j4YV24BnlZU50F6POuF/VBHQbtfigsoBS9gvqcXq/rZ" +
       "gLb9q8cvv6AxvYb/sPK+Gxt1VHr2CfD/1qv//VHhB62Xv4PU9olzRjk/5D8Z" +
       "vfH5/rPqT16o3HK8DFzzZny20/Nnwf+uUAev8p5wZgl4bG+SUn9F8fRNso/t" +
       "TdrKIgZWUwv97s1xE/IPpZVzcMl9F3BZPQSL6g3g8oe/Hbi8Dfi7Xt5Y51j6" +
       "8HfBUuOQpcYNWPqxb4sl1U/2Pn2epR9/S5b2sXEAFuTbalexq9Xi/u9ef9Jb" +
       "DiPtYlTuDBV3xhELD69c9cpRzj3Xwwh475WVix1FzeWTiNrvrZxj9Llvm1EQ" +
       "WfedDMb4nvn8T/y3j//u33v6SwBcqMpt2yIdAgFyasZxUuxc/fgbn3js7te+" +
       "/BPlCwVQ4fxvf/PRF4pRP3kzcYvi42dEfbQQlS9hnpGjeFTm/bp2LO05uLkV" +
       "OPh3L218/wuDejRsH/2YudxbtufIdAFh2cwZ8oRjkfh0Ypody4KNSbZFqJpN" +
       "El2hbhL2RIjGXI0xttv11EKhZlNH4MymZ5vqrlkd5TQNkeOBvNBp01JIVQ9m" +
       "MjJrruwVIkEBt2nJdBwHCz6tuatYDsrFGTUMOMxQpl5F1tpayTUkz0PUQwcs" +
       "pELNFmsMof5iIQUUuWFGUq0/5ul4kUSzfBiv14FAqbHcQ6st3EbcqqMpqIvk" +
       "E2k60yg2NSQaWQRilDi0BVKSDRWP5vmC5il3HPbkWdBgzepmthwbvhMksTSm" +
       "7GAxxaUJOXetDTybTcXh2Akcs54JfaG7kCRF6JFRb9hqCyNq1PAIF5fhcSYP" +
       "+2MH1VaW48Cpw2iNrd1xUwtlxM0EimboxoUoKdisUqtPp0iQUqRlN5PNeInM" +
       "16OGa0VrLBTHUX+TssMukQvGEjYoqWWgyHIkrCi1Kiw0lVtEWrzkEa8p8sEI" +
       "i5W5FqThhjeG+oya2WOrYU9df5LLnV1/pbLmKhQTUs0gdx1KArVlkUWfDdpB" +
       "LzWddBSPtinVGdELlmnq07xjuvN8LGujOlsTlm5sSSJJx83qkMFg10aRXoOf" +
       "JusGH9Qsje1UJSoiTadf39GjqrNZOLEgz/1NkIyqtW6aNO2Ap/1MpltVs7ms" +
       "yhbD7LZDTIoGbEiQY24jhTRiDaojdJQ5OxSHNm4y4ySjjtAbZLht9kIKmc/9" +
       "pM1gE5XcdHgJQMByxzYS12ASO5jaEqELw2bLyvrTdluuLfrRqt7iEL5BOcRA" +
       "nrYTYE5ZwXbMkoDDjkZN2ZVtZupqNqNJX66yfFxNWnFbbY2c3pIW6h1kYSXd" +
       "/tSS+vRkRSTdueTLi+6Sg8IMliKwmGD8fBFMCXFUD+hNVIfTwJTN3S6Ux4Hs" +
       "0sM2TtQlD7Oltcf7aGJb7V6atrupz3mNuNoyorCX1sZstxHt7HE/EWrN1UhP" +
       "+F6mEFuhnyhalZCEDUdXu1WSbEEeK0KZsI0ZGa+3LWo9c+umIeLYQIQS1oAS" +
       "WYfsgKa9ZNhZZOFazOuEsZJ6yIru+gjTnMljft6fpYgzHs95xUixTnNNtOq8" +
       "PdP62Dio1Wg2Mht8uN3EvQZa69rjodUmkGUvadKuphuaQ5qGgeOSRXVonTAF" +
       "rsdSELXu9HhWqaNI04pEd6ENZ4LYQtercKPgs44qUWYNa9SJMIX0Vs5HmVwX" +
       "yR2qQyMeIggjFnCxT+LrhI6SSF6sab3a7oLsQxhVxSRw0qrJObMRl7YbxLA/" +
       "aMkjbjq3qc08CTa25EM4hyURbExbnIoPY5yaRH20lw124ihT+iuOSMUaM1qw" +
       "fZHqMNakirYjdSbvdkFsIeYg6lTzsLbNNxsEW0fbdiJmHXXV3jorBXOcptLd" +
       "may9NYbTNN50arrOcQlFd13OaUuU5LpUOs0yhN2RGkWjtR2BU6YXZKMqLUjN" +
       "yGS9EdJfyG23TWe7Zs3tblpeIxRz3CRWu4kn1chqGo3yaTxoODUW7bkZVtcD" +
       "cjZlEGo3VFVravYZCh16uScqvttt98jGWIkNkAz7ubFFyKqP92cLKiMWKj1k" +
       "8xnpdamNN21gBtVDRRxaseQaq1UnvbkwZCZtawoQCrMmjWDRweZTNwsmLF1T" +
       "+jOPFOrN8QZZGwCW6pyWMmmNyGeCGSVuxzStfMdAfoZ5KwQydCi10aAxFJsC" +
       "wmz9TT43q6ofDolVnq+Ww5auuG0GeJNWQ72VAGERqnoqYbse2VnnndhEdl1S" +
       "HDCc3QqaLRxTa0IHgdjExkbDLuk5SG/ZYMyEwJptb2fiHsT2+sOh1nYiubZO" +
       "2zLur9Y+mAsdeJ3YXk+29krFpqovEgq9dkl+48/qkGFoCscZ295Wh7akutlO" +
       "6uiK2W0IMuEQj+lyS47hXK+OqAIh9FE2lPMMSNtDdVfd9Qa6Pk1ghWwKLZwP" +
       "/Z7fgU3EHfbpmTbZJUgHag+TRiiJ6TjO2y2Y3dXkWsOYp0ZqNeRNW4eMzZJr" +
       "5hrOkqsAdiN4tphpLWTJV+UQ79Jp12xOcnhisltovMxUqUZg7G66W3fq5CZY" +
       "CIipdPJVE5XmNK5Du6yPiRKA3Y4uN6sUT3l5IlFjkJ9nLazVFGNmQeIBUNAi" +
       "6LjTUSh16jtqMK2z3qxpspN86hkJIYzEZptee0HSQyjTF4fscjiTUk1HucVo" +
       "t7XpXq+KQjWJ6nWqjSzOeWLVGzWM3LO3ZsvSFTTpbJ0W00DRGgBntLczR9sm" +
       "rvYnDE6gDQTxkUSPOS+Voy6uV4fxfGgyOGYAONssqksPYnAmNE2tmiQjUu1M" +
       "mARvtDIBElbykiMdl5zWHDSUQh9H+b6/qGO+IjsMQ0sby9pKrVZLQ/3ACnKR" +
       "8+Jud6eL4ngXbJQhRGgbo98aJ92eiBJUgBN5CisddgZAr9ODIuCcOTuIuf5u" +
       "wSZmVlt1kE7IOpt5qjOcPqpZlN0X3e5uYfNNHePFHRNmthjHTl2us3NnhaWB" +
       "sq05rhlBsiWFKGITiDtGMQ91yBaqqVDsTrRUFZgujK5SfEMEEPAsfKCSu6lF" +
       "9CeCkapc1uzJrUhvSCvdWq5xbsGOharU9+gWhRgzKKviHakugHdXtkvnWmsA" +
       "LeZqu7/OHLcNz2GDqfE+76k5TbBa7NT87bAx2q5BRlOrerXG0kUbO9itLrsK" +
       "x/barujCmJW1Ws26iHX8qkYgTi8fhUNT4WIJrBDkYk3W7GU40KQux2DorjaI" +
       "t0rLVOMlCTE9UbHGY1ZU58xkm9WoSavhLNMpOxpsmQXdbmjQFoKWSG8xC/0O" +
       "FgzJuSQoTsbnMQ87dhQzFLWCk/o6q6JskqS2PtsxwohfT1p1euazyggeNFbD" +
       "tJEtLJ2p4VUuWtTGTXTY5aFqRkPR3NX6I8lCe2044319LeyULgbe1lcelHAL" +
       "YZvnAA/rIYd3ZlI2ypG0YYamzSpofZ6bicT39OXO2g4MXk2mjl+1nAnFwbxY" +
       "xzta1GjCUNSNOJiZLeW5aLJEe+DMasi0qffqEK7rIVlLPBSf08tO3YsnHCbY" +
       "I6bXiXGpHWrQQJAlj5ypwzwedwfrdWscJcYM8+aey/GQiuUxHZNYI3DVnGhP" +
       "vdSbIFslhFvoMo7JLuQ3UZTQRjA0QHfTGhYb/pCo05I7V8mV1Zj2PUrDhpGS" +
       "7Wa1ySwPB3ZY1VDOo+qNWj3d7BR4G7a0rKYksIbAno9qUCxTQytmM4bdRZO8" +
       "2942pbyzaHcmraG4HGHIpp54TrKCBv6Cd9Uqr8/oVO7U501vkcF+XdWURQ+F" +
       "Y5GejOZWbAjqSBvzAcHK7XW2ZiNqQcWbTWMaMkLLpA0/MvK0P9hFHoNv+QnH" +
       "h5DINqYiptSBz8JKj1FQxgq5Rqpg/aEioxCnjhZU2KiL9YU3CoQErtc0AyWN" +
       "eTKIREgjlt2ZP7KxeYo3VN1R9Tk08/AuRW9yszHCOIQNBnB/I0SbLIAEEnK9" +
       "9nDr+ZY7XaKdhCApQQzHjWVdM6PauN4B+dKqunPHtDNuLRbjYJXmTC/abXfJ" +
       "0jcZYw7ZCl/NRkprypNBc6a6VWQojpvmiFhgWGQvup14u4WdVhPmLKbJDEQv" +
       "8myiV2Xd1mS16iRLIYLoYQ8X1+xSoxaypFZ1bCSAHL+53uHNmqBhtZW+lFxi" +
       "oq4kX9XC5XLT7mEL3nGZjdLzplR7yKaDtTyIdwhc722UOeolqOPMBuI472ks" +
       "kbjwXEB6ZE6hTZgRUB/PQ4LyzG3Mz3FxzHRC1+9CKBPOqbnFWCN6RSn11ipC" +
       "equxUJsloj7q015zA9aSKteYsU4cizZmdpEN3kl0QhGUbjjj0FSywu6yCi+X" +
       "5gIXtsPluMtNpnCsa45stwkVGXDiduQM0Vnb7UqKgy+Y/ibL7GyB4l5D4xWn" +
       "zwkNvrOudRooo9CByqHNjhWOFmPLwzNmO+PqE4FTRVqoMXmXH6L9XJ1wHawX" +
       "jpuN8dKqBuusnSnMbF7LA3xd51PX62atupilmRuha7Jeb1jZgNdMpwdxLtFf" +
       "72qctHC93rhqivJu3TN69GwiYGRjBRL0Ou62VbWjwukqGGWdBJt2Fk2jU5ei" +
       "1aq3AMDGA2h1ILVLuZPUXI/MwODqxkzWrZqh79JsCuwlDfO65rpNbB5CXZES" +
       "dyjqEKvWbCj5O1ru4+p2IG7r074xnve73IAnOIubRnrXwcGbjbOMcTgzJsZm" +
       "Y4tGwg7nkeQiir8aTNiaARLLTau14nGkYa17fKySLEuIugiTO2cEXikzngi6" +
       "fRyC2luWW9J9n4JZflCbDIKMhGGFHwskj2l0h+YGNiU55CJvmztNXezw9cDG" +
       "may+pGU3pDcUFDXSOUfMYFjUEhlivb7fUNe5zkJ9leIIuMV1a1rHYaFaL96M" +
       "BvNNrdHcCkssnaIzbLjpTZq2S/nEZjpBRTL1F2rf8ua6PGzGdkPJuTSuwzp4" +
       "XcxhL0nDNK9X610l8raOLPaZdRK520zLF9HAzfMaSjVpstZHtxJJUGPQ3d7h" +
       "HfDOsODN6jgT6V6rZbZxd+vMQw9VlFXdXwY9BPPGO4TASMizNA7NurgB0nJ+" +
       "azuDfpN1gojTx9t2D0pmWDyYz7AVWLBlxAZ+a9p2m4yjNeRgtbTJ7HjYxPtx" +
       "PY7zOMAZpCGPYkrVB42pPp4roe73EHLXB9BBp5oA4l6JCT4SaqQGzMO165wi" +
       "8vV1bBHVyGpGHTjeCIt+Vcx9xICEZm+KEplG4rO6pFn8cofBGM5wvUi0+Fm7" +
       "3f7AB4qtlH/wnW3x3F/uZh0fG1q5WNHwk9/BLs6+6amieOZ416/8XTz8cnH0" +
       "BeP0rt+pr5YHRztnz9zoEAbn214cDWRPc/Ww2Kd/7EZnh8o9+s+8+trrGvuz" +
       "yNHHrJfiyp2xH/x1V9/q7pnPpUV9c8z0gwWPT4Lr/YdMv//8VuWJWq6/T/l9" +
       "e7XeZHv3l2/S9itF8Ytx5V5Tj0/OnZQ7xiem+KdvtaF2etRzAt5dPCzORhCH" +
       "AhLvvIC/fq7t4KyNn72hjYs/IlX1oPgcUA71G0Xxa3HlUhTLYbzf2iy+KV53" +
       "73Hr29qJlv7l29XSFXBNDrU0eWe0dHBC8GJJ8MUbE/xmSfAHRfGv48rdXil7" +
       "+fm7ePT5E0H/zdsVtAjMlw8Fffmdd4cvv5WMf1QU/zEuzoFqJyY+J+V/ertS" +
       "Pgau6FDK6J2X8k/fSsr/URR/DCxZuvIe");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("z87J+JW3K2PxYTg/lDF/Z2S8cPLd8cUTv/2Lt5L2L4vif8aV2wL/8AvkKTn/" +
       "19uV83vB9eqhnK++47Y8uPUtpDu4WFS/FZcnMq9nyYPKdyJhGlceuPaQYXFK" +
       "6pFrjjHvj96qn3390h0Pvz77t/tzBkfHY+9kKncYieuePtRyqn4xCHXDLqW/" +
       "c3/EJSiluTeuPHwDTC4OoZWVgumDe/b0l+PK5fP0wNLl/2m6B+PKXSd0YKh9" +
       "5TTJQ3HlFkBSVB8OjhaI6o0WiJ5uyIl7ahk4ygcOTi3ph6ovHe2BtzLDcZfT" +
       "x/SKL9jlMfOjr80Jd3gY53OvU+MPfaP5s/tjgqor53kxyh1M5fb9icVy0OKL" +
       "9VM3HO1orIuD57553y/c+cxRinLfnuET7z3F2xPXP4dHrIO4PDmX//OH/9kP" +
       "/KPX/7D82vf/Ae2VU3f/LwAA");
}
