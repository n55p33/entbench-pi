package org.apache.batik.svggen;
public class SVGClipDescriptor implements org.apache.batik.svggen.SVGDescriptor, org.apache.batik.svggen.SVGSyntax {
    private java.lang.String clipPathValue;
    private org.w3c.dom.Element clipPathDef;
    public SVGClipDescriptor(java.lang.String clipPathValue, org.w3c.dom.Element clipPathDef) {
        super(
          );
        if (clipPathValue ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              org.apache.batik.svggen.ErrorConstants.
                ERR_CLIP_NULL);
        this.
          clipPathValue =
          clipPathValue;
        this.
          clipPathDef =
          clipPathDef;
    }
    public java.util.Map getAttributeMap(java.util.Map attrMap) {
        if (attrMap ==
              null)
            attrMap =
              new java.util.HashMap(
                );
        attrMap.
          put(
            SVG_CLIP_PATH_ATTRIBUTE,
            clipPathValue);
        return attrMap;
    }
    public java.util.List getDefinitionSet(java.util.List defSet) {
        if (defSet ==
              null)
            defSet =
              new java.util.LinkedList(
                );
        if (clipPathDef !=
              null)
            defSet.
              add(
                clipPathDef);
        return defSet;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfXBU1RW/uyHf3wEC8hFITGDCx65UsdIACiFA6CZsCabT" +
                                                              "5WN5+/bu5sHb9x7v3U02obaIOuIfpZQC0o7wT2MRiuB06rS21Yl16sdoO4PS" +
                                                              "WutImdo/tJZRxtF2Smt77r3ve3fDMLWZeXdv7j333HvOPed3zrnnrqJSQ0ct" +
                                                              "WCEhMqphI9SjkKigGzjZLQuGsRXG4uKjJcLHO9/rXxFEZTFUNyQYfaJg4PUS" +
                                                              "lpNGDM2VFIMIioiNfoyTdEVUxwbWhwUiqUoMTZeM3owmS6JE+tQkpgSDgh5B" +
                                                              "jQIhupTIEtxrMiBobgROEmYnCa/xT3dFUI2oaqMO+UwXebdrhlJmnL0Mghoi" +
                                                              "u4VhIZwlkhyOSAbpyulosabKo2lZJSGcI6Hd8nJTBZsiy/NU0PZU/afXDw81" +
                                                              "MBVMFRRFJUw8Yws2VHkYJyOo3hntkXHG2Iu+gUoiqNpFTFB7xNo0DJuGYVNL" +
                                                              "WocKTl+LlWymW2XiEItTmSbSAxHU6mWiCbqQMdlE2ZmBQwUxZWeLQdr5trRc" +
                                                              "yjwRjy0OH310Z8OPS1B9DNVLygA9jgiHILBJDBSKMwmsG2uSSZyMoUYFLnsA" +
                                                              "65IgS2PmTTcZUloRSBau31ILHcxqWGd7OrqCewTZ9KxIVN0WL8UMyvyvNCUL" +
                                                              "aZC12ZGVS7iejoOAVRIcTE8JYHfmkil7JCVJ0Dz/ClvG9i8DASwtz2AypNpb" +
                                                              "TVEEGEBN3ERkQUmHB8D0lDSQlqpggDpBs4oypbrWBHGPkMZxapE+uiifAqpK" +
                                                              "pgi6hKDpfjLGCW5plu+WXPdztX/loX3KRiWIAnDmJBZlev5qWNTiW7QFp7CO" +
                                                              "wQ/4wppFkeNC87MHgwgB8XQfMaf56dev3bOkZeJlTjO7AM3mxG4skrg4nqi7" +
                                                              "OKe7c0UJPUaFphoSvXyP5MzLouZMV04DhGm2OdLJkDU5seXFr+0/iz8Ioqpe" +
                                                              "VCaqcjYDdtQoqhlNkrG+AStYFwhO9qJKrCS72XwvKod+RFIwH92cShmY9KIp" +
                                                              "MhsqU9n/oKIUsKAqqoK+pKRUq68JZIj1cxpCqBw+tBa+dsT/2C9B28NDagaH" +
                                                              "BVFQJEUNR3WVym+EAXESoNuhcAKsfk/YULM6mGBY1dNhAexgCFsTw+k0VsID" +
                                                              "gxu6ZUlbhw1RlzQw9xC1Mu3/zD9H5Zs6EgiA6uf4HV8Gn9moykmsx8Wj2bU9" +
                                                              "187HX+VGRR3B1AxBnbBliG8ZYluG+JahvC1RIMB2mka35hcM17MHHB2QtqZz" +
                                                              "YMemXQfbSsCytJEpoFtK2uaJON0OGlgQHhcvNNWOtV5e9kIQTYmgJkEkWUGm" +
                                                              "AWSNngZoEveY3luTgFjkhIT5rpBAY5muijgJiFQsNJhcKtRhrNNxgqa5OFgB" +
                                                              "i7pmuHi4KHh+NHFi5P7Bb94WREFvFKBblgKA0eVRit02Rrf7vb8Q3/qH3/v0" +
                                                              "wvH7VAcHPGHFioZ5K6kMbX5b8KsnLi6aLzwdf/a+dqb2SsBpIoBfAQS2+Pfw" +
                                                              "wEyXBdlUlgoQOKXqGUGmU5aOq8iQro44I8xIG1l/GphFNfW7OfAtNR2R/dLZ" +
                                                              "Zo22M7hRUzvzScFCwqoB7eQffvv+7UzdVvSod4X9AUy6XIhFmTUxbGp0zHar" +
                                                              "jjHQvXMi+t1jVx/exmwWKG4ttGE7bbsBqeAKQc0Pvbz3rT9dHr8UdOycQMjO" +
                                                              "JiDzydlC0nFUNYmQsNsC5zyAeDKgArWa9nsVsE8pJQkJGVPH+ld9x7Kn/3ao" +
                                                              "gduBDCOWGS25MQNn/Ja1aP+rO//ewtgERBpxHZ05ZBzGpzqc1+i6MErPkbv/" +
                                                              "9bnfe0k4CQEBQNiQxjDD1SDTQZBJPhMSMLaSBtcQD67WxFQKMyO3i6GkmgnR" +
                                                              "xAm8j930ckZxG2vvoFpiDBGb66JNh+H2GK9TutKpuHj40ke1gx89d42J6M3H" +
                                                              "3AbSJ2hd3CZpsyAH7Gf4EW2jYAwB3R0T/dsb5InrwDEGHEVAaGOzDoia85iT" +
                                                              "SV1a/sfnX2jedbEEBdejKlkVkusF5pmoElwCG0MAxjnt7nu4RYxUQNPAREV5" +
                                                              "wucN0FuZV/i+ezIaYTc09rMZP1l5+tRlZpoa5zHbvB6IDx4oZlm9gwZn3/ji" +
                                                              "705/5/gIzws6i0Ogb93Mf26WEwf+/I88lTPwK5Cz+NbHwucem9W9+gO23kEh" +
                                                              "uro9lx/TAMmdtV84m/kk2Fb26yAqj6EG0cyiBwU5S307BpmjYaXWkGl75r1Z" +
                                                              "IE95umyUneNHQNe2fvxzYin0KTXt1/ogr4ZeYSt8HSYadPghL4BYp48tWcja" +
                                                              "RbRZaiFMuaZLUGlhH8RUT8KUgNAQv6OQBjGh6eCdHFtpu5I2/Zzf3UWNcoNX" +
                                                              "iPnwLTD3W1BEiEEuBG2i+acttpqgauu063CKDt3lO+tXJzlrztlzsb0n+yvz" +
                                                              "p3xuEHZ7iIlTHZOkQ04qZFG3TkI9MArWnKPwMrdYts8qlfEDR08lNz++jPte" +
                                                              "kzeD7oEC8cnf//u10IkrrxRI3iqJqi2V8TCWfd4+1+PtfawQclznnboj7z7T" +
                                                              "nl57MzkXHWu5QVZF/58HQiwqDiD+o7x04K+ztq4e2nUT6dM8nzr9LM/0nXtl" +
                                                              "wwLxSJBVfdyn86pF76IurydX6RjKW2Wrx59vtQ2rntpRC3yrTMNaVTiFKWCT" +
                                                              "dmJQbKkvGgbsVNp1o/SqBrIJg2wRRpgtxcXtCxua21d83MaNqKUAravEPPSL" +
                                                              "n8diCxtETtxWiLG3tHzidIX4dubFv/AFtxRYwOmmPxH+1uCbu19jl1lBrcdW" +
                                                              "octywMpcmWGDrZs6qopG+K6YumG//3sJBcsyYSJlIBsJb5UyOGmmH59XiTYp" +
                                                              "f5ZeeJzRubQf7ZHXfHjXD1dxtbYWcRqH/pmvXLl4cuzCOQ4EVL0ELS720pT/" +
                                                              "vEUrg45JqhvHQD7Z8KWJ998d3BE087A62uRyFurVOokIpD10cH8Bg53mNRPO" +
                                                              "ed0j9b883FSyHpCnF1VkFWlvFvcmvd5XbmQTLrtxHlQcXzSN5j/wF4DvM/pR" +
                                                              "Y6ED3Giaus3Hhfn26wLkRHSeoMAi6DI++iTJ5yO0yUDumMbEfqQ05R1xwpJy" +
                                                              "oxA6eV5HB3o0Ni7ZntBgxdqo6QnRmweYYkuLAAz93/C6YhN8Z0wuZywuo4zL" +
                                                              "GJdkH22O23ZR506jeZ1ywr8R/fdBrvyjkyj/Mdp8G+oJUD7kA5LCijnI6+j4" +
                                                              "MUf7hz8P7ecIasx77aAZ98y8x1T+ACieP1VfMePUvW+yAGo/0tUA6KWysuzO" +
                                                              "CV39Mk0HSZh4NTxD1NjPOEEziuQRUFryDjv6Dzj9aVCLn56gUvbrpjtLUJVD" +
                                                              "B6x4x03yJEElQEK757UCNRxPjXMBV3ZhqpFpf/qNtG8vcRfXFHnYY7aFDtmo" +
                                                              "CXAXTm3q33ftzsd5cS/KwtgY5VINmMDfGewcoLUoN4tX2cbO63VPVXZYGNbI" +
                                                              "D+w4zmyXufWAZWr0xmf5Kl+j3S6A3xpf+dxvDpa9Dui7DQUEKGm35RcROS0L" +
                                                              "oXpbJB/7IF9iJXlX5/dHVy9Jffg2K9NMrJxTnD4uXjq9440jM8ehdK/uRaWQ" +
                                                              "MeIcq27WjSpbsDisx1CtZPTk4IjARRJkD7DWUeMUaCXO9GKqs9YepU9DBLXl" +
                                                              "vWcXeFCDknYE62vVrJI0obnaGfG8sltpVFbTfAucEVcK8ABtHspx4C6JR/o0" +
                                                              "zQLyqs805qQPFsYR2j7PurT51X8B2Xf+/OgaAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
