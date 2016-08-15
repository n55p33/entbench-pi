package org.apache.batik.css.engine.sac;
public abstract class AbstractAttributeCondition implements org.w3c.css.sac.AttributeCondition, org.apache.batik.css.engine.sac.ExtendedCondition {
    protected java.lang.String value;
    protected AbstractAttributeCondition(java.lang.String value) { super(
                                                                     );
                                                                   this.value =
                                                                     value;
    }
    public boolean equals(java.lang.Object obj) { if (obj == null || obj.
                                                        getClass(
                                                          ) !=
                                                        getClass(
                                                          )) { return false;
                                                  }
                                                  org.apache.batik.css.engine.sac.AbstractAttributeCondition c =
                                                    (org.apache.batik.css.engine.sac.AbstractAttributeCondition)
                                                      obj;
                                                  return c.
                                                           value.
                                                    equals(
                                                      value);
    }
    public int hashCode() { return value == null ? -1 : value.
                              hashCode(
                                ); }
    public int getSpecificity() { return 1 << 8; }
    public java.lang.String getValue() { return value; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "F6cw/t1Z31p7euKyQKBurTE3E3HnZUVcUe+7Tn/m7U//7PRXjo1aFcOywpHO" +
       "xzf7H1uU6P5f/z3H5CLG5almfPwD4bMnmzrWfSD43WCD3K3p3FwGAdvlXXUm" +
       "+ddgS/mPgqRigNRLdn3dT5UUuvAA1JSmU3RDDZ41n10fWsVQeyaYzvMHOs+2" +
       "/jDn5lDoIzX2a/JFtrnwLLE9fok/sgWI6NwvWG7BZnluvCjEzUnZCGqFP+60" +
       "YiS2d2ETsWBwdz7UWVO3iLYNm1sFWIIcLiepKNzxOKmkdtJ3w5f4q3NKK+ft" +
       "DV8u7oKO67dgcTF6uyRqClFM5BQRDunKG9UhnWkOhSLcdhxO9OD5hUptcU2Y" +
       "3H90Irbl1EoL3o3Z5Wsn3M6efudfb4RO/Oq1PHVRFdf0WxU2whSPYqW4ZZZD" +
       "9YhbiIvO92qP/OaF1qENN1O94FjzDeoT/L0AlGgr7KN+UV7Z/4embesSu26i" +
       "EFngM6d/yad6zr5231LpSFBcuSy3ybmqZTO1ZztLtcHgbqluy3KZxRmUTUNQ" +
       "zYFnlY2yVfmLgbwIDmB3my/jVhdZzJeCCuctK1SIvYeL5C1xO4EoU872wLGb" +
       "2fUuoqAvBX7Va8hJAPCIfbNb1btLOtja+1sLpHPyMFh0M54Mf7n/0u43xHFW" +
       "In4yRvRgB3DmqbLqLVt8DH8BeP6ND0qLA9YNqbHDvqYtzNzTMIcUTQY+BcJ7" +
       "G98fPnnlaUsBf+T3EbODRx/7OHToqOVx1mV/cc5928tjXfgtdbDhKN2iYrsI" +
       "jq7fndv7vSf3HgjaZ7ODk4qopimMqjkHDqVlttktWe/9Yt2LhxtLusCXu0ll" +
       "SpX3pFh3LBvPFWYq6jkH9/uAi25barQ5J4E2J0WLOB0vEqf/i+oABzp0MU4z" +
       "sMcgTWbBs86G/boiPoRNItdjCrEWAf9jRea+hM2jkFcSUDJ1gIEF1R77OPE1" +
       "4umPc1Ii25/MPMeEP/d5bPeFT8p28+HptA3QefO2K8RaxD4ni8xNYHOck9oh" +
       "xvt0JkEZL8l8DEcPucY48QkYoxHnmuDpsTXquXljFGItovBTRea+gc0kAAmM" +
       "0Z8pflwznPpfmCHNSVPhrx5Yks/O+Q5rfTuUnpmoq5w18cAlkf4z3/emQsCO" +
       "pxTFWzR6+uW6weKy0G+qVULq4vVNSK43qIrAU6AVijxnMX2bk7lFmDA5iY6X" +
       "5wVOpufjgdWh9VK+CGnRTwl1qHh76b7PSbVLB5taHS/JD2F1IMHuBb1wzg14" +
       "yi/i8f4ZNzrpDIv3Ho+5THxqd4J9yvrYPiidm9i0+cFrd56yviNICh0fx1Wm" +
       "QIi3PmlkiqRFBVdz1irfuOx67bNVS5zc02AJ7HrLXA+kOyC06QiqJt8N22zN" +
       "XLTfnVz78k8Olr8FWXM7CVBOpm3Pvcik9RRUp9sjuakMCkpx9W9f9vWxdSvi" +
       "f/qluCqSnAuin35Qunh6x9tHZk82B8mUblIGaZWlxQ3r3jF1K5NGjAFSI5ud" +
       "aRARVpGpkpUnaxH/FG/8wi62OWsyo/gVCu4Iudk/99sdXKtHmbFBS6kxO9NO" +
       "cUey/gdg+1R1Std9DO6Ip0J6yMo7eBqAx8FIj647xVH5X3QREPblT0TYviO6" +
       "2Fz6DygtGU2GGwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "8FvPfD2/hfhfC49vm7slAAA=");
}
