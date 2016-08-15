package org.apache.batik.css.parser;
public class DefaultDirectAdjacentSelector extends org.apache.batik.css.parser.AbstractSiblingSelector {
    public DefaultDirectAdjacentSelector(short type, org.w3c.css.sac.Selector parent,
                                         org.w3c.css.sac.SimpleSelector simple) {
        super(
          type,
          parent,
          simple);
    }
    public short getSelectorType() { return SAC_DIRECT_ADJACENT_SELECTOR;
    }
    public java.lang.String toString() { return getSelector(
                                                  ) + " + " +
                                         getSiblingSelector(
                                           ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ye2wUxxkfn7ExfuAHz/AwL0NroLehBFRkmmKMHUzPcMLE" +
       "Uk3DMbc3d7f23u6yO2ufndJC1AoaKQhRktAoQWpFlLRKQlQ1aqs2EVWkJlHS" +
       "SklR07QKqdRKpQ/UoErpH7RNv29m93Zvzz5EVfWkndub+eab7/n7vrnnbpA6" +
       "xyadzOBxPmUxJ95v8CS1HZbp06njHIK5lPp4Lf37kev7d8RI/SiZn6fOkEod" +
       "NqAxPeOMkpWa4XBqqMzZz1gGdyRt5jB7gnLNNEbJIs0ZLFi6pmp8yMwwJBih" +
       "doK0U85tLe1yNugx4GRlAiRRhCRKb3S5J0GaVdOaCsiXhsj7QitIWQjOcjhp" +
       "S4zRCaq4XNOVhObwnqJNNlmmPpXTTR5nRR4f07d5JtiX2FZhgrUvtn5062y+" +
       "TZhgATUMkwv1nIPMMfUJlkmQ1mC2X2cF5xj5MqlNkKYQMSddCf9QBQ5V4FBf" +
       "24AKpG9hhlvoM4U63OdUb6koECdryplY1KYFj01SyAwcGrinu9gM2q4uaSu1" +
       "rFDx0U3K+cePtH2vlrSOklbNGEZxVBCCwyGjYFBWSDPb6c1kWGaUtBvg7GFm" +
       "a1TXpj1PdzhazqDcBff7ZsFJ12K2ODOwFfgRdLNdlZt2Sb2sCCjvV11WpznQ" +
       "dXGgq9RwAOdBwUYNBLOzFOLO2zJnXDMynKyK7ijp2PV5IICtcwuM583SUXMM" +
       "ChOkQ4aITo2cMgyhZ+SAtM6EALQ5WTYrU7S1RdVxmmMpjMgIXVIuAdU8YQjc" +
       "wsmiKJngBF5aFvFSyD839u8886Cx14iRGpA5w1Qd5W+CTZ2RTQdZltkM8kBu" +
       "bN6YeIwufvl0jBAgXhQhljQ/+NLNXZs7r7wuaZbPQHMgPcZUnlIvpee/vaKv" +
       "e0ctitFgmY6Gzi/TXGRZ0lvpKVqAMItLHHEx7i9eOfizL5z4LvtLjDQOknrV" +
       "1N0CxFG7ahYsTWf2fcxgNuUsM0jmMSPTJ9YHyVx4T2gGk7MHslmH8UEyRxdT" +
       "9ab4DSbKAgs0USO8a0bW9N8tyvPivWgRQubCQ5rhWU3kR3xzoit5s8AUqlJD" +
       "M0wlaZuov6MA4qTBtnklDVE/rjima0MIKqadUyjEQZ55C6rjYGYCECp7WJa6" +
       "Ot+j2cChNzMGMWvwYaYzDP84Rp31fz6viPovmKypAdesiAKDDvR7TT3D7JR6" +
       "3t3df/OF1Jsy6DBRPMtxsgNEiEsR4kKEOIgQlyLEq4pAamrEyQtRFBkQ4M5x" +
       "AAZA5ubu4Qf2HT29thYi0ZqcA75A0rVlFaovQA8f8lPq5Y6W6TXXtrwaI3MS" +
       "pIOq3KU6FpxeOwdQpo572d6chtoVlJDVoRKCtc82VZYBBJutlHhcGswJZuM8" +
       "JwtDHPwCh6mszF5eZpSfXLkweXLkK3fHSKy8auCRdQB4uD2JWF/C9K4oWszE" +
       "t/XU9Y8uP3bcDHCjrAz51bNiJ+qwNhobUfOk1I2r6Uupl493CbPPA1znFPIQ" +
       "ILMzekYZLPX4EI+6NIDCWdMuUB2XfBs38rxtTgYzImjbxftCCIsmzNNPwrPe" +
       "S1zxjauLLRyXyCDHOItoIUrIZ4etp379iz9tFeb2q01rqE0YZrwnhHDIrENg" +
       "WXsQtodsxoDu/QvJbzx649RhEbNAsW6mA7tw7ANkAxeCmb/2+rH3Prh26Wos" +
       "iHMOJd5NQ6dULCmJ86SxipJw2oZAHkBITDGMmq77DYhPLavRtM4wsf7Zun7L" +
       "S3890ybjQIcZP4w2355BMH/XbnLizSP/6BRsalSs0IHNAjIJ+wsCzr22TadQ" +
       "juLJd1Z+8zX6FBQQAG1Hm2YCh2uFDWrLcx3zadhNO5CXWgHcMOGVtE8nj6qn" +
       "u5J/kOXqrhk2SLpFzyqPjLw79pZwcgNmPs6j3i2hvAaECEVYmzT+x/Cpgeff" +
       "+KDRcUKWho4+rz6tLhUoyyqC5N1VOspyBZTjHR+MP3n9ealAtIBHiNnp8w9/" +
       "HD9zXnpOdjnrKhqN8B7Z6Uh1cNiB0q2pdorYMfDHy8d//OzxU1KqjvKa3Q8t" +
       "6fO/+tdb8Qu/e2OGclDn5E1b9qr3YDCXoHthuXekSnu+3vqTsx21A4Aag6TB" +
       "NbRjLhvMhHlCm+a46ZC7gv5JTISVQ9dwUrMRvYAzS6Edweo0uVUVRcmhatwv" +
       "Pj5BZwWBBrcU5pMJ9tsE8d0lpYhQioi1BA7rnTAIlzs91NGn1LNXP2wZ+fCV" +
       "m8Jw5VeCMOYMUUt6rR2HDei1JdEiuZc6eaC758r+L7bpV24Bx1HgqEJT4Byw" +
       "oWgXyxDKo66b+5ufvrr46Nu1JDZAGnWTZgaoAHsyD1CWge/0TNH63C4JMpMN" +
       "MLQJVUmF8hUTmOirZoaQ/oLFRdJP/3DJ93c+c/GaQDvPS8vDDD+Bw6YS7olP" +
       "fbQrC+NeGQebrJytcRaBfemh8xczB57eEvOct4uD3qb1KZ1NMD3EKoacylqN" +
       "IXFVCMrd+/PP/f5HXbndd9Jl4FznbfoI/L0KXLdxdgiJivLaQ39eduje/NE7" +
       "aBhWRawUZfmdoefeuG+Dei4m7kWyV6i4T5Vv6ilP2kabwQXQKE/TdSW/tvu+" +
       "VDy/KjMX7RlColQKZ9taJVnzVdbGcIA61ppjpQ7VF/8zYscQDhkZp8n/Mkdw" +
       "YsQS86mSSh24tgye7Z5K2+/cGrNtraKxW2VtEgeA8wZuykuwj5dtIsPxdhwP" +
       "LQjTHPtfmKbIycqqtwaEmaUVf2LIi7f6wsXWhiUX739XpGXpctwMCZZ1dT0U" +
       "n+FYrbdsltWE2s0SdS3xdZKT5VUuN9imiRehygm556twEZhpDye1MIYpT4Et" +
       "o5RQPsV3mO5hThoDOjhUvoRJHgHuQIKvZyzfUVur3ct6oTWyAbWGNegzjVyp" +
       "2tVUIrJw7aLbuTYEwevKoEv8K+XDjCv/l4JL2sV9+x+8uf1p2XWrOp2eRi5N" +
       "UO3lBaAEVWtm5ebzqt/bfWv+i/PW+6DeLgUOUmZ5KK5HoBmxMISWRVpSp6vU" +
       "mb53aecrPz9d/w6U1MOkhnKy4HDoPyH5Bwj0tS7UiMOJyq4GYF30yj3dT0zd" +
       "uzn7t9+KYkdkF7RidvqUevWZB355bukl6KmbBkkd1CtWHCWNmrNnyjjI1Al7" +
       "lLRoTn8RRAQuGtXLWqb5GO0UM1LYxTNnS2kW72ycrK3sFytvutAYTDJ7t+ka" +
       "Ga/pagpmyv4u89HetazIhmAm1FPvkX0aegNCNpUYsiy/nZ7bbQkE6I+2jmJS" +
       "7P6WeMXh2/8B4eM97rEWAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "d9/+m89/OzuJ+2+B3gHCaiEAAA==");
}
