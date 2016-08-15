package org.apache.batik.ext.awt.image;
public class ConcreteComponentTransferFunction implements org.apache.batik.ext.awt.image.ComponentTransferFunction {
    private int type;
    private float slope;
    private float[] tableValues;
    private float intercept;
    private float amplitude;
    private float exponent;
    private float offset;
    private ConcreteComponentTransferFunction() { super(); }
    public static org.apache.batik.ext.awt.image.ComponentTransferFunction getIdentityTransfer() {
        org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction f =
          new org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction(
          );
        f.
          type =
          IDENTITY;
        return f;
    }
    public static org.apache.batik.ext.awt.image.ComponentTransferFunction getTableTransfer(float[] tableValues) {
        org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction f =
          new org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction(
          );
        f.
          type =
          TABLE;
        if (tableValues ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        if (tableValues.
              length <
              2) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        f.
          tableValues =
          (new float[tableValues.
                       length]);
        java.lang.System.
          arraycopy(
            tableValues,
            0,
            f.
              tableValues,
            0,
            tableValues.
              length);
        return f;
    }
    public static org.apache.batik.ext.awt.image.ComponentTransferFunction getDiscreteTransfer(float[] tableValues) {
        org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction f =
          new org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction(
          );
        f.
          type =
          DISCRETE;
        if (tableValues ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        if (tableValues.
              length <
              2) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        f.
          tableValues =
          (new float[tableValues.
                       length]);
        java.lang.System.
          arraycopy(
            tableValues,
            0,
            f.
              tableValues,
            0,
            tableValues.
              length);
        return f;
    }
    public static org.apache.batik.ext.awt.image.ComponentTransferFunction getLinearTransfer(float slope,
                                                                                             float intercept) {
        org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction f =
          new org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction(
          );
        f.
          type =
          LINEAR;
        f.
          slope =
          slope;
        f.
          intercept =
          intercept;
        return f;
    }
    public static org.apache.batik.ext.awt.image.ComponentTransferFunction getGammaTransfer(float amplitude,
                                                                                            float exponent,
                                                                                            float offset) {
        org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction f =
          new org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction(
          );
        f.
          type =
          GAMMA;
        f.
          amplitude =
          amplitude;
        f.
          exponent =
          exponent;
        f.
          offset =
          offset;
        return f;
    }
    public int getType() { return type; }
    public float getSlope() { return slope;
    }
    public float[] getTableValues() { return tableValues;
    }
    public float getIntercept() { return intercept;
    }
    public float getAmplitude() { return amplitude;
    }
    public float getExponent() { return exponent;
    }
    public float getOffset() { return offset;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVaDXAdVRW+76VN0vw0P/0LbZM2P4Xp33tQQcBUIA39SX1t" +
       "QhOKpJR0s+++ZJt9u8vufc1LoAKd0UZHS62lINLOqMUWKJTpyCijQB3GAgPi" +
       "ABVEBBQZRSpjqyOiKHjOvfve7tv3djvRZszM3rfZe86553z33HPOvbtH3ieT" +
       "LZM0UI1F2IhBrchKjXVJpkXj7apkWT3wrE++q0j6643vrr88TIp7ydRByVon" +
       "SxZdpVA1bvWSekWzmKTJ1FpPaRw5ukxqUXObxBRd6yUzFKsjaaiKrLB1epwi" +
       "wUbJjJEaiTFT6U8x2mELYKQ+BppEuSbRNm93a4xUyLox4pDXucjbXT1ImXTG" +
       "shipjm2VtknRFFPUaEyxWGvaJIsNXR0ZUHUWoWkW2apeYkOwNnZJHgRNj1R9" +
       "8NHuwWoOwTRJ03TGzbM2UEtXt9F4jFQ5T1eqNGndRL5AimKk3EXMSEssM2gU" +
       "Bo3CoBlrHSrQvpJqqWS7zs1hGUnFhowKMdKYK8SQTClpi+niOoOEUmbbzpnB" +
       "2vlZa4WVeSbeuTi6964bq48VkapeUqVo3aiODEowGKQXAKXJfmpabfE4jfeS" +
       "Gg0mu5uaiqQqo/ZM11rKgCaxFEx/BhZ8mDKoycd0sIJ5BNvMlMx0M2tegjuU" +
       "/d/khCoNgK0zHVuFhavwORhYpoBiZkICv7NZJg0pWpyReV6OrI0tnwMCYC1J" +
       "UjaoZ4eapEnwgNQKF1ElbSDaDa6nDQDpZB0c0GRktq9QxNqQ5CFpgPahR3ro" +
       "ukQXUE3hQCALIzO8ZFwSzNJszyy55uf99ct33ayt0cIkBDrHqayi/uXA1OBh" +
       "2kAT1KSwDgRjxaLYPmnm42NhQoB4hodY0PzgljNXLWk4/oygmVOAprN/K5VZ" +
       "n3ywf+qLc9sXXl6EapQauqXg5OdYzldZl93TmjYgwszMSsTOSKbz+IYT19/2" +
       "AD0VJmUdpFjW1VQS/KhG1pOGolJzNdWoKTEa7yBTqBZv5/0dpATuY4pGxdPO" +
       "RMKirINMUvmjYp3/DxAlQARCVAb3ipbQM/eGxAb5fdoghJTARbrhaiDij/8y" +
       "YkUH9SSNSrKkKZoe7TJ1tN+KQsTpB2wHo/3g9UNRS0+Z4IJR3RyISuAHg9Tu" +
       "wJUpDbOokoTph+ikySZltB0s0zWQ0WNKmgXTtCqlyYhEBJ3P+P8Mm0Y0pg2H" +
       "QjBRc71hQoUVtkZX49Tsk/emVqw883Dfc8IFcdnYODJyFWgSEZpEuCY8qIIm" +
       "Ea5J5KyakFCIKzAdNRJeAnM8BNECwnXFwu7Na7eMNRWBexrDk2CCkLQpJ221" +
       "OyElkwf65KO1laONb170VJhMipFaSWYpScUs1GYOQHyTh+wQUNEPCc3JK/Nd" +
       "eQUToqnLNA5hzS+/2FJK9W3UxOeMTHdJyGQ9XN9R/5xTUH9y/O7h2zfeemGY" +
       "hHNTCQ45GaIgsndhAsgG+hZvCCkkt2rnux8c3bddd4JJTm7KpNQ8TrShyesi" +
       "Xnj65EXzpUf7Ht/ewmGfAsGeSbA4IY42eMfIiVWtmbiPtpSCwQndTEoqdmUw" +
       "LmODpj7sPOG+W8Pvp4NbVODiXQrXYns181/snWlgO0v4OvqZxwqeVz7bbez/" +
       "5Qt//BSHO5OCqly1Qzdlra6wh8JqeYCrcdy2x6QU6N64u+sbd76/cxP3WaBo" +
       "LjRgC7a4JmAKAeYvPnPTa2+9efBk2PFzRkoMU4FiiqazVmIHKQ+wEoY731EI" +
       "4qZK+SKzWq7VwEGVhCL1qxRX1r+qFlz06J92VQtHUOFJxo+WnF2A8/y8FeS2" +
       "5278ewMXE5IxbzugOWQiGUxzJLeZpjSCeqRvf6n+m09L+yGtQCi3lFHKozPh" +
       "IBA+a5dw+y/k7cWevkuxWWC5vT93gbnqqz5598nTlRtPP3GGa5tboLkne51k" +
       "tAr/wub8NIif5Y1OayRrEOguPr7+hmr1+EcgsRckyhCbrU4TgmY6xzVs6skl" +
       "v/rJUzO3vFhEwqtImapL8VUSX2VkCrg3tQYh3qaNK68SkztcCk01N5XkGZ/3" +
       "AAGeV3jqViYNxsEe/eGs7y8/dOBN7maGkDGH85dgCsgJq7zMd1b2Ay9f+otD" +
       "X983LAqFhf7hzMNX989OtX/H2x/mQc4DWYEixsPfGz1y7+z2K05xfieiIHdL" +
       "Oj9tQVR2eJc9kPxbuKn4p2FS0kuqZbus3iipKVynvVBKWplaG0rvnP7cslDU" +
       "QK3ZiDnXG81cw3pjmZMu4R6p8b6yUPiaAdc8e2HP84avEOE3HZzlAmwW54cF" +
       "P24mRs5NnZieulP9FqQ5JQlRbZtdNi7r2iKPtXS9I2b6vAIMgm7G4ejXNr66" +
       "9XkeM0sxkfZkrHOlSUi4roBdLXT+BP5CcH2MF+qKD0T5Vdtu14Dzs0Ugemqg" +
       "y3kMiG6vfWvo3ncfEgZ4/ctDTMf2fuWTyK69Ig6KnURzXjHv5hG7CWEONteg" +
       "do1Bo3COVX84uv1Hh7fvFFrV5tbFK2Hb99Ar/34+cvdvni1QZBUp9m4QF3wo" +
       "WwdNz50bYdDVX6768e7aolWQgjtIaUpTbkrRjniuH5ZYqX7XZDk7FMc3bdNw" +
       "YhgJLYI5EAkU28uwWSvCR6tvtGrP9e46uObb/jnfx7ulQO/242ZksqXqdmGw" +
       "3p4S/Ol23V/HcFnqUh6O+O9mr3H94zQOVWq01Wv0MS4ZaJwfNyPlDFMuj0pW" +
       "7plNdkHybCqm/4byE09a3/39MeFmhZa7Z5d4+FCp/HryBF/uOGJnVrfZmVBy" +
       "ga3bBWKJXvc/blWALYm1gW62wZ3k3gVNlGhcogv8A4gLvwPfa37h1gPNv+UJ" +
       "vVSxILJDCCuwQ3fxnD7y1qmXKusf5lXvJIyE9sLKPdrIP7nIOZDg6Fdhk+K3" +
       "ibwVzx1PENg+dYvwKd4uwmYpJw0zUmyk+lVFRq9XNEnlEq+BxyrVBsQ2eCM2" +
       "o4ZTSYQFL/+/jtnVGua/SLsKWzf0wkyf2KwpeiR7EgSd6QIhqj6npljHzXUS" +
       "9BtT9/zusZaBFePZpeGzhrPsw/D/eTBni/yn3KvK0zvem91zxeCWcWy45nk8" +
       "wivy/nVHnl19vrwnzA+bROWQd0iVy9SaG6fLYOecMrXcyNzsuMho4ennMe1W" +
       "MeUBtfPugL492HwVvEfGqReeEkB+Z345ig/aDFflGhRvtXHG27lwNdlRqckn" +
       "3t4TGG/9uBmZwpepTA2+I0p4NP3Wf6Fpsz1Ws4+m3w7U1I8bNJXwfJ2lhMN7" +
       "Nf3OODWdA1eLPVaLj6aHAzX142akFHZ1/PSnkKL3j1PR8+BaYA+1wEfRo4GK" +
       "+nGzzCliITUfCVAz7Qy3Kzsc/ysmnhNG13Cu/VcoE1kvO+t5ms85Gqa4er9T" +
       "ZF6BHtyx90C8876LMpn+8+BBTDeWqnQbVV26VPD7sawdS1DtK+FaZtuxzAu6" +
       "g1R+KuKxCIC1+GsFz1lGTYDUgHBzIqDvGWyehPQ1QFlHHIBS2EgGK+x6zJnR" +
       "42dzvOANt4hwHrBQBK91l9tmLR83WNg8VQCoVltiazBQrjjL+GAnA9B6BZsX" +
       "GKkGtHowiftA9fOJggqjTo9tWM85g6rbltg9TqjeDoDqHWx+LRzrasXip9o+" +
       "aL0xUWhh6FNt29RzhtaQLXEoGK2wI4rHxgQf8XQAZH/B5j1GagAyfHEjmT6A" +
       "nZrIlThimzdyzgBL2xLTwYAVcVFFDmAOah/7oxbiEj8Ua3K1lExKPqD9YwJA" +
       "q8K+mXCN2SaOBYCGza5cdMoCWANMLg/oq8SmmJESDFF2JdyVRSFUMgEo4Bzz" +
       "tXaHbcod40fBjzXA0rqAvtnYTINKClDoxtMO7ksODNMnAIZp2IcHEvtsW/aN" +
       "HwY/1gBTFwT04TCh+YxMzeQrcS6CpMwBo3GifKIerv22RfvHD4Yfa4DBywL6" +
       "LsZmKSMVWOrkbFocKCITCcVB256D44fCjzXA3CsD+tqw+YyAoi1nV+RA0TpR" +
       "UOAe70HbngfHD4Ufa4C5sYA+PAENrWakHKBY6d52OUismSgk8MjwmG3OsfEj" +
       "4ccaYO31AX2bsOmBXQ4g0ens6xwcrj0XOKQZaTzrVw74dq4u70ss8fWQ/PCB" +
       "qtJZB659VZwfZr7wqYiR0kRKVd3vj1z3xYZJEwoHtUK8TeJH9PgOtiF4D8nI" +
       "ZP6LBoX6BVeCkTo/LkaKoHVTK4xML0QNlNC6KVUoY7yUMD7/ddPpjJQ5dLBd" +
       "FDduEhOkAwneWsL5YLtc7RxSipd0abGTnuOeNF4tzTjbXGdZ3K/sEQL+nV3m" +
       "jC8lvrTrk48eWLv+5jOfvk98MiCr0ugoSimPkRLx9QIXiueEjb7SMrKK1yz8" +
       "aOojUxZkduY1QmFnwcxxvJq0wY7FQH+a7XmdbrVk36q/dnD5Ez8bK34pTEKb" +
       "SEiCTcum/NeZaSNlkvpNsfy3SBslk7/nb114z8gVSxJ/fp2/MCbiSHeuP32f" +
       "fPLQ5pf31B1sCJPyDnAzLU7T/D3r1SPaBipvM3tJpWKtTIOKuDOX1JxXVFPR" +
       "9SX8Ao/jYsNZmX2KH5ww0pT/di7/M50yVR+m5go9pcVRTGWMlDtPxMx4jlpT" +
       "huFhcJ7YU4ntDdhcwwt/8Me+2DrDyLy8nDLd4CFhczZSeI88Q1/it3i38z/u" +
       "zXtLgysAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "L7+mMD+HnN+9b6cC6PbAcX/IVDeqeUSW");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("7XqUd4jjg5nYHwYHusOBnnwtu9fU9es4e52/5VrCV86o+xdZ8RsBdJ+mBl0F" +
       "4NeD5EAFWdWX94b6p2/1GvHo2CewZk3zVdPndlifu4lYz+3fUm/Xx756BuA/" +
       "yIp/GUBXAGA+W5s6Be2/erdos2UAfoeW/8tE+/Uz0P5RVvz7rXkbup/vPzsF" +
       "8H94t4CzFQZzB9i8iYDP71vlCw7jvNWfnIH6v2XFHwMCAqizXZKSdwrmb9wM" +
       "l052mJObiPmWPbGOTwD/szOA/3lW/Petc7cly5JOwf0/3gXuy9nF+8Hx0g73" +
       "S+8A99tb/Tx36xl1F7KL3wugi1kA7xZfu4fQzkHvAto9B278mR20z9x8aFfO" +
       "qLs3K+4MoEsAGpdtDMmtvsd217vAdl92MdsD8soO2ys3H9vDZ9Q9mhUPBNDd" +
       "B7y73UyS09ge4YPv1nqPgOPVHcJXbz7CHzyj7pmseCqA7sqm0mPr3Ht8V28G" +
       "vtd3+F6/+fjwM+rKWQFv8RHHFsz3+IrvFl+2pv8rO3y/cvPxPX9GHZkVzwbQ" +
       "nQBf8+jK+x7ec+8WXrYT6Us7eF+6+fD6Z9TRWdEGuSmAx+yX8PfgOu8EXBxA" +
       "T7zlhvZsc+6D1/3pZvtHEfkLr12+9MBr43+93el18GeO2/vQpUVomkf3Uh45" +
       "v+B66mKrh9u3OyvdHNw4gB49O8MPoNvy7wzJOX7baxpAD57WK4BuAeXR1h8J" +
       "oPfeqDVoCcqjLT8KZuCTLcH98++j7aQAumPfLoAubE+ONlHA6KBJdqpuN/kc" +
       "396w3bAab59zHjzqeflEf+9b2fSwy9EN5ZkK8r9UHWyeCrd/qnpB/uJrPfrj" +
       "3yn/3HZDu2xKaZqNcqkPXdzurc8HzTZgPXHqaAdjXeh84Lt3/9rtTx88N929" +
       "FXgfBUdke+zGm8eblhvk273Tf/jA33/uF177w3y3xf8DGdVB6es2AAA=");
}
