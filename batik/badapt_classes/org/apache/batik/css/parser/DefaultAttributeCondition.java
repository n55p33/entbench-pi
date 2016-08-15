package org.apache.batik.css.parser;
public class DefaultAttributeCondition extends org.apache.batik.css.parser.AbstractAttributeCondition {
    protected java.lang.String localName;
    protected java.lang.String namespaceURI;
    protected boolean specified;
    public DefaultAttributeCondition(java.lang.String localName, java.lang.String namespaceURI,
                                     boolean specified,
                                     java.lang.String value) { super(
                                                                 value);
                                                               this.
                                                                 localName =
                                                                 localName;
                                                               this.
                                                                 namespaceURI =
                                                                 namespaceURI;
                                                               this.
                                                                 specified =
                                                                 specified;
    }
    public short getConditionType() { return SAC_ATTRIBUTE_CONDITION;
    }
    public java.lang.String getNamespaceURI() { return namespaceURI;
    }
    public java.lang.String getLocalName() { return localName; }
    public boolean getSpecified() { return specified; }
    public java.lang.String toString() { if (value == null) { return "[" +
                                                              localName +
                                                              "]";
                                         }
                                         return "[" + localName +
                                         "=\"" +
                                         value +
                                         "\"]"; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1ZfWwUxxUfn41tjI0/+DZgwBgQH7kLaaBNTSDG2MbksC0M" +
                                                              "RDWBY29vzrewt7vZnbPPTskHVQStVEQoX62C/6gckVIS0qpRUjVBVFE+UGir" +
                                                              "AG2aViFVWzW0KWpQ1bQqbdP3ZvZuP853yFLpSTu3N/Pem/fevHm/N3Nnb5AJ" +
                                                              "lkkaqMaCbMigVrBNYz2SadFYqypZ1lboi8gniqW/7rredV+AlPaRyQnJ2ixL" +
                                                              "Fm1XqBqz+shcRbOYpMnU6qI0hhw9JrWoOSAxRdf6yDTF6kwaqiIrbLMeo0iw" +
                                                              "XTLDpFZizFSiKUY7bQGMzA2DJiGuSajFP9wcJpWybgw55DNd5K2uEaRMOnNZ" +
                                                              "jNSE90gDUijFFDUUVizWnDbJckNXh/pVnQVpmgX3qKtsF2wKr8pxQeOL1Z/e" +
                                                              "Opyo4S6YImmazrh51hZq6eoAjYVJtdPbptKk9Qh5jBSHySQXMSNN4cykIZg0" +
                                                              "BJNmrHWoQPsqqqWSrTo3h2UklRoyKsTIAq8QQzKlpC2mh+sMEsqZbTtnBmvn" +
                                                              "Z60VVuaYeGx56OiJXTXfLybVfaRa0XpRHRmUYDBJHziUJqPUtFpiMRrrI7Ua" +
                                                              "LHYvNRVJVYbtla6zlH5NYilY/oxbsDNlUJPP6fgK1hFsM1My082seXEeUPav" +
                                                              "CXFV6gdbpzu2CgvbsR8MrFBAMTMuQdzZLCV7FS3GyDw/R9bGpgeBAFjLkpQl" +
                                                              "9OxUJZoEHaROhIgqaf2hXgg9rR9IJ+gQgCYj9XmFoq8NSd4r9dMIRqSPrkcM" +
                                                              "AdVE7ghkYWSan4xLglWq962Sa31udK059Ki2UQuQItA5RmUV9Z8ETA0+pi00" +
                                                              "Tk0K+0AwVi4LH5emv3YwQAgQT/MRC5qXv3zzgRUNF94WNLPHoOmO7qEyi8ij" +
                                                              "0cnvzmldel8xqlFu6JaCi++xnO+yHnukOW1AhpmelYiDwczghS1vfumJM/Tj" +
                                                              "AKnoJKWyrqaSEEe1sp40FJWaHVSjpsRorJNMpFqslY93kjJ4DysaFb3d8bhF" +
                                                              "WScpUXlXqc5/g4viIAJdVAHvihbXM++GxBL8PW0QQsrgIZXwzCXiw78ZSYQS" +
                                                              "epKGJFnSFE0P9Zg62m+FIONEwbeJUBSifm/I0lMmhGBIN/tDEsRBgtoDsmXh" +
                                                              "zoREGNpA41JKZdmEBnsqxs0PYsQZ/8e50mj3lMGiIliSOf6EoMJe2qirMWpG" +
                                                              "5KOp9W03X4i8I4INN4jtMUZWwfRBMX2QTx+E6YNi+mDe6UlREZ91KqohggCW" +
                                                              "cC8kA8jGlUt7d27afbCxGKLPGCwB/yNpoweVWp2MkUnzEflcXdXwgmsrXw+Q" +
                                                              "kjCpk2SWklQEmRazH9KXvNfe4ZVRwCsHNua7YAPxztRlGoOslQ8+bCnl+gA1" +
                                                              "sZ+RqS4JGVDD7RvKDylj6k8unBx8cvvjdwdIwIsUOOUESHLI3oP5PZvHm/wZ" +
                                                              "Yiy51Qeuf3ru+D7dyRUe6MkgZg4n2tDojwu/eyLysvnSS5HX9jVxt0+EXM4k" +
                                                              "2HuQJhv8c3hSUXMmraMt5WBwXDeTkopDGR9XsISpDzo9PGBr+ftUCItJuDeb" +
                                                              "4Flpb1b+jaPTDWxniADHOPNZwWHj/l7j1C9/+sfPcXdnEKbaVRr0Utbsymoo" +
                                                              "rI7nr1onbLealALdByd7vnHsxoEdPGaBYuFYEzZh2wrZDJYQ3PzU24+8/+G1" +
                                                              "0asBJ84ZwHoqCtVROmsk9pOKAkbCbIsdfSArqpAtMGqatmkQn0pckaIqxY31" +
                                                              "r+pFK1/686EaEQcq9GTCaMXtBTj9s9aTJ97Z9fcGLqZIRlR2fOaQiVQ/xZHc" +
                                                              "YprSEOqRfvLy3G++JZ0C0IBEbSnDlOfeEu6DEm75TCjSOCcCcFAAMPav9mYC" +
                                                              "3G29qagFu1ZJwiIN2CB3T89u+WBTz+8FgM0ag0HQTXsu9PXt7+25xEOgHPMC" +
                                                              "9uNEVa5dD/nDFX81Ymk+g08RPP/BB5cEOwRY1LXaiDU/C1mGkQbNlxaoMb0G" +
                                                              "hPbVfbj3mevPCwP8kO4jpgePfu2z4KGjYl1F3bMwp/Rw84jaR5iDTTNqt6DQ" +
                                                              "LJyj/aNz+3703L4DQqs6L4q3QZH6/C/+fSl48jcXxwCKsqiuq1QSyexeDPZs" +
                                                              "ap/qXR9h1IavVr96uK64HbJKJylPacojKdoZc0uF0s1KRV0L5tRUvMNtHi4O" +
                                                              "I0XLYB14GPF2Fdfl7qxGhGtE+NgmbBZZ7gzrXTNXiR6RD1/9pGr7J+dvcru9" +
                                                              "Nb47oWyWDOH0WmwWo9Nn+BFwo2QlgO7eC10P16gXboHEPpAoA9Jb3SagcdqT" +
                                                              "fmzqCWW/+vHr03e/W0wC7aRC1aVYu8QzOZkIKZRaCQDytLHuAZFBBsuhqeGm" +
                                                              "khzjczpwF88bOz+0JQ3Gd/TwKzN+sOb0yDWeygwhYzbnL8bawgPd/KTooMeZ" +
                                                              "K5//+emnjw+KmCqwQ3x8M//ZrUb3//YfOS7nYDnGpvHx94XOPlPfuvZjzu+g" +
                                                              "FnI3pXPrIUB+h/eeM8m/BRpL3wiQsj5SI9sns+2SmkIs6IPTiJU5rsHpzTPu" +
                                                              "PVmIMro5i8pz/LvWNa0fL90boYR5gt6ByMm4hPPgabTRo9EPkUWEvzzMWZbw" +
                                                              "dhk2d2UQaaJh6gy0pDEfKFUVEAtsqi5Lapet42qBxNg+iM1OIasrb0hu95qA" +
                                                              "8pfYcy3JY4IoEpZgE8nVNB83I5XoSAtKWLptS+dYysbHqex8eFbY063Io6xa" +
                                                              "UNl83OBWy6AyQDKNYccXfZomC2iadmZcnp2Rf0qJ77zjri6crUwwX83NdyTl" +
                                                              "ADG6/+hIrPvZlQE7i64HhZlu3KXSAaq6ROE101xPVtjMD+HOFvtg8pHf/bCp" +
                                                              "f/14annsa7hNtY6/58H+XpY/0fhVeWv/n+q3rk3sHkdZPs/nJb/I72w+e7Fj" +
                                                              "sXwkwG8cxN7PuanwMjV7d3yFSVnK1LxgtzC7rrW4XgvgWWev6zp/HDqR4wuJ" +
                                                              "bMGZj7UAan6lwNhT2DwGdV0/ZdmDYLa2/4JdhuDX/a73FgbBktBN5q8b8GdH" +
                                                              "2gn9x2+3SQuDHHZsNXj/cNYVdRkvdtiu6Bi/F/OxFvDUsQJjJ7A5DGUFeLHL" +
                                                              "n7ccbzx9p7zRAE+3bVL3+L2Rj7WAxd8uMDaKzSlI4eCNsAdvHFeM3AFXTMEx" +
                                                              "hNWHbHseGr8r8rEWMPdcgbHvYXNGuKLXgxGOK757p6KiHp5dtj27xu+KfKwF" +
                                                              "zH21wNh5bF5mpJzp7pNj1g2v/C/ckGZkVt77LayZZ+ZcsYtrYfmFkeryGSPb" +
                                                              "3uPQlr26rQSQiqdU1V3Vud5LDZPGFW5epajxxEnmTUZmF7iCwwsF/sLNeEPw" +
                                                              "XGRk6lg8jBRD66a8BOnaTwkJmX+76X7GSIVDB5OKFzfJZZAOJPh6xcic8VcX" +
                                                              "uj1sgWO6Ccif6950kbcsya7stNutrKuSWeipAPjfJhm0Tok/TiLyuZFNXY/e" +
                                                              "XP2suCKSVWl4GKVMgqOnuK3KIv6CvNIysko3Lr01+cWJizK1Ua1Q2Nkds10h" +
                                                              "vBUQzsAoqvfdn1hN2WuU90fXnP/JwdLLcILZQYokRqbsyD1apI0UlFo7wrlH" +
                                                              "bKiO+MVO89JvDa1dEf/Lr/nhjYgj+Zz89BH56umdV47MHG0IkEmdZAKUfTTN" +
                                                              "zzwbhrQtVB4w+0iVYrWlQUWQokiq5/w+GQNewl3J/WK7syrbixeMjDTmXl/k" +
                                                              "XsvCQXeQmuv1lMYTXRVUZ06P5/8cexNVpAzDx+D0uK542rFpTuNqQNRGwpsN" +
                                                              "I3O7U7bO4AmgY+x6BNs/8FdsPvov+CRU8lIdAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
