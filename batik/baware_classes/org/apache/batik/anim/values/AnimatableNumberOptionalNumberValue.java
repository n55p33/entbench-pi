package org.apache.batik.anim.values;
public class AnimatableNumberOptionalNumberValue extends org.apache.batik.anim.values.AnimatableValue {
    protected float number;
    protected boolean hasOptionalNumber;
    protected float optionalNumber;
    protected AnimatableNumberOptionalNumberValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableNumberOptionalNumberValue(org.apache.batik.dom.anim.AnimationTarget target,
                                               float n) {
        super(
          target);
        number =
          n;
    }
    public AnimatableNumberOptionalNumberValue(org.apache.batik.dom.anim.AnimationTarget target,
                                               float n,
                                               float on) {
        super(
          target);
        number =
          n;
        optionalNumber =
          on;
        hasOptionalNumber =
          true;
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue)
                result;
        }
        float newNumber;
        float newOptionalNumber;
        boolean newHasOptionalNumber;
        if (to !=
              null &&
              interpolation >=
              0.5) {
            org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue toValue =
              (org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue)
                to;
            newNumber =
              toValue.
                number;
            newOptionalNumber =
              toValue.
                optionalNumber;
            newHasOptionalNumber =
              toValue.
                hasOptionalNumber;
        }
        else {
            newNumber =
              number;
            newOptionalNumber =
              optionalNumber;
            newHasOptionalNumber =
              hasOptionalNumber;
        }
        if (res.
              number !=
              newNumber ||
              res.
                hasOptionalNumber !=
              newHasOptionalNumber ||
              res.
                optionalNumber !=
              newOptionalNumber) {
            res.
              number =
              number;
            res.
              optionalNumber =
              optionalNumber;
            res.
              hasOptionalNumber =
              hasOptionalNumber;
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public float getNumber() { return number;
    }
    public boolean hasOptionalNumber() { return hasOptionalNumber;
    }
    public float getOptionalNumber() { return optionalNumber;
    }
    public boolean canPace() { return false;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        if (hasOptionalNumber) {
            return new org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue(
              target,
              0.0F,
              0.0F);
        }
        return new org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue(
          target,
          0.0F);
    }
    public java.lang.String getCssText() {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        sb.
          append(
            formatNumber(
              number));
        if (hasOptionalNumber) {
            sb.
              append(
                ' ');
            sb.
              append(
                formatNumber(
                  optionalNumber));
        }
        return sb.
          toString(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMUZCWwc1fXv+ozjOydO4iSOCU0wu4QChZojiXESw/poHCJ1" +
       "U+L8nf3rnWR2Zpj5a29CTSGiIiCKaGqOckRFSsQhIKiCHiqgINQChaJyFEoR" +
       "UBWkplBUogqoSoG+9//szrFHcEVUS/M9+/9777/7vf/ngQ9IjW2RTqbzCN9t" +
       "MjvSr/MRatks2adR294Cc2PKrVX0n9uPDp0bJrVx0pym9qBCbbZBZVrSjpMl" +
       "qm5zqivMHmIsiRgjFrOZNUG5auhxMk+1BzKmpioqHzSSDAG2UitG2ijnlprI" +
       "cjbgEOBkSQw4iQpOouuCy70x0qgY5m4XfKEHvM+zgpAZdy+bk9bYTjpBo1mu" +
       "atGYavPenEVONQ1t97hm8AjL8chO7SxHBRfHzipSQdfDLR9/elO6VahgDtV1" +
       "gwvx7M3MNrQJloyRFne2X2MZ+3JyJamKkdkeYE66Y/lNo7BpFDbNS+tCAfdN" +
       "TM9m+gwhDs9TqjUVZIiT5X4iJrVoxiEzIngGCvXckV0gg7TLCtJKKYtEvPnU" +
       "6PSt21t/WkVa4qRF1UeRHQWY4LBJHBTKMglm2euSSZaMkzYdjD3KLJVq6h7H" +
       "0u22Oq5TngXz59WCk1mTWWJPV1dgR5DNyircsAripYRDOb9qUhodB1nnu7JK" +
       "CTfgPAjYoAJjVoqC3zko1btUPcnJ0iBGQcbuSwAAUOsyjKeNwlbVOoUJ0i5d" +
       "RKP6eHQUXE8fB9AaAxzQ4qSjLFHUtUmVXXScjaFHBuBG5BJAzRKKQBRO5gXB" +
       "BCWwUkfASh77fDB03o1X6Jv0MAkBz0mmaMj/bEDqDCBtZilmMYgDidi4OnYL" +
       "nf/4vjAhADwvACxhfv7dY2t7Oo88I2EWlYAZTuxkCh9TDiaaX1zct+rcKmSj" +
       "3jRsFY3vk1xE2Yiz0pszIcPML1DExUh+8cjm33z7qvvZ+2HSMEBqFUPLZsCP" +
       "2hQjY6oaszYynVmUs+QAmcX0ZJ9YHyB18B5TdSZnh1Mpm/EBUq2JqVpD/AYV" +
       "pYAEqqgB3lU9ZeTfTcrT4j1nEkLq4CGN8Cwh8k/858SOpo0Mi1KF6qpuREcs" +
       "A+W3o5BxEqDbdDQBXr8rahtZC1wwaljjUQp+kGbOAqBlohNUy4rgVjOU04TG" +
       "hrIYRMMmCk81+WsrAkXQ+cz/z7Y51MacyVAIDLU4mCY0iLBNhpZk1pgynV3f" +
       "f+yhseekC2LYOHrkZC1wEpGcRAQnEeQkIjmJfAlOSCgkGJiLHEkvARvvgmwB" +
       "6bpx1ehlF+/Y11UF7mlOVoOBqgC0y1e2+tyUkq8DY8rh9qY9y99a81SYVMdI" +
       "O1V4lmpYhdZZ45DflF1OCmhMQEFz68oyT13BgmgZCktCWitXXxwq9cYEs3Ce" +
       "k7keCvmqh/EdLV9zSvJPjtw2efXW750eJmF/KcEtayALIvoIFoBCou8OppBS" +
       "dFuuPfrx4VumDDeZ+GpTvqQWYaIMXUEXCapnTFm9jD469vhUt1D7LEj2nEJw" +
       "Qh7tDO7hy1W9+byPstSDwCnDylANl/I6buBpy5h0Z4Tvton3ueAWzRi8a5wn" +
       "/05wdb6J4wLp6+hnASlEXTl/1Lzrjy/87etC3fkS1OLpHUYZ7/WkPSTWLhJc" +
       "m+u2WyzGAO7N20Z+dPMH124TPgsQK0pt2I1jH6Q7MCGo+fvPXP76228dfCVc" +
       "8PMQJ7NMy+CQBFgyV5ATl0hTBTlhw5UuS5A5NaCAjtN9qQ4uqqZUjEaMrf+0" +
       "nLzm0b/f2CpdQYOZvCf1HJ+AO3/SenLVc9s/6RRkQgpWbldtLpgsB3Ncyuss" +
       "i+5GPnJXv7Tkx0/Tu6CwQDK31T1M5OeQVIOQfCEnq4ryTNLIyFwjkwzssYVa" +
       "44wLS58l8E4X45moIkGNiLVzcTjZ9kaMPyg9PdmYctMrHzZt/fCJY0I+f1Pn" +
       "dZBBavZKn8RhZQ7ILwhmtE3UTgPcmUeGvtOqHfkUKMaBogL53B62INHmfO7k" +
       "QNfU/enJp+bveLGKhDeQBs2gyQ1URCaZBSHB7DTk6Jx54VrpDpP1MLQKUUmR" +
       "8EUTaJKlpY3dnzG5MM+eXyx45Lx7DrwlXNMUJJYU3HE2konAc47jjueUDjsc" +
       "TxHjahxOy7t4rZlNwAkh4N8NFQgG7BoWlML482x/ZcDsO5pN2JDF1QwE7YTT" +
       "FZ0xskPZ1z3yrux4TiqBIOHm3Rv9wdbXdj4vUkI91gmcx42aPFUA6oknH7VK" +
       "Ob6AvxA8n+OD/OOE7C7a+5wWZ1mhxzFNdJZVFQ4lfgGiU+1v77rz6INSgGAP" +
       "GABm+6av/yJy47QMctkoryjqVb04slmW4uAwjNwtr7SLwNjw18NTv7p36lrJ" +
       "Vbu/7euHU82Dr372fOS2Pz9booeAhGtQXrBpPvIhV/utI0W66LqWx25qr9oA" +
       "NWaA1Gd19fIsG0h6aUKnb2cTHnO5LbiY8AqHpuEktBqsIKYvqZA4tuNwkVj6" +
       "Jg790m/P/x+DDyf6ykbUOicA1lWIKBw2FsdOOdSAaFWyoRKxg8OQGAT9dAUt" +
       "7MRBcbWQ/Cq0IBcWFVq8xb4WT1w5uF3G/S9/4w/3/PCWSelrFSIngLfw38Na" +
       "Yu9f/lWUykVTVSKYAvjx6AN3dvRd8L7Ad7sbxO7OFbfQ0CG6uGfcn/ko3FX7" +
       "6zCpi5NWxTniiw4YeoY4HGvt/Lk/Rpp86/4jqjyP9Ra6t8XBaPZsG+yrvCFS" +
       "zX3hEGilFsHT5bhRV9ADQ0S8TLhOeGpxg1IOG5K+Lrr/gsvNcX1p8ni+ZPrZ" +
       "/Bo8pzgbnVKGzamKbJbD5qQtTW3/eUVgx5ykiP++5Xm/lJO6hGFojOrBTIY/" +
       "t+UCol45Q1FXwNPjMNtTRtTrKopaDpuTZsMnZynLXF+B3VypbCT+akngfB3M" +
       "RovyecEiS8pdgYj6cnDv9IHk8KE1YScLbYX+mBvmaRqbYJqHVD1S8iWPQXHp" +
       "40bim8373/ll9/j6mRwNca7zOIc//L0U0sDq8vkoyMrTe9/r2HJBescMTnlL" +
       "A1oKkrxv8IFnN65U9ofFDZdMEUU3Y36kXn9iaLAYz1q6v1quKNgVMwNZCc+g" +
       "Y9fBoDMev0CVQw1UnRph0Zr8EaDnS141iKSJOHcXHPnu44VulaoXNSAybIU4" +
       "P6lQD+/D4Q5OZouLSdA0NHXuniJ47vzKGoVbC8psw7UOeCYcZU7M3A7lUCtI" +
       "+0iFtZ/hcBgCE05hnkzi6uHhE6CHObjWDc+UI8zUzPVQDrWCrE9WWHsKh8dK" +
       "VRBc2Ovq4/ET5RdYdK9xhLpm5vooh1pB5hcqrP0eh2dBH+AXxfrw+MdvT5R/" +
       "YJzc4Ah1w8z1UQ61gsxvVFh7E4dXoV9QqD5CZXXxeMVrJ8orMHVPO6JMz1wL" +
       "5VADknqy592C6tEKqngPh3c4aUiqshhtMQI+8e4J0IaoYdjx3eGIdMfMtVEO" +
       "tYKwH1VY+wSHDzlphBiJM8twi5irimMnQBXtuLYYnkOOPIdmropyqOXFDYUr" +
       "rFXj5GfgE6CKPmgBoY3KtwCt4rIKz0ER+anOVc7nX8kxlJMVX+KbBd6bLSz6" +
       "riq/BSoPHWipX3Dg0tdEf1n4XtcInWIqq2neE5jnvda0WEoVum6U5zFT6KIZ" +
       "DniV2h44TckXlCjUJJHaOJlXEomTavznhZ0LSg3CclIj/nvh4JTQ4MLBtvLF" +
       "C9IBbRSA4OsiU4Z/yN/kF4w173jG8pwLVvj6afHRO9/7ZuVn7zHl8IGLh644" +
       "dvYheX+vaHTPHqQyO0bq5KeEQv+8vCy1PK3aTas+bX541sn5k0abZNgNg0We" +
       "sO2DTGeiO3QEbrbt7sIF9+sHz3vid/tqXwqT0DYSopzM2VZ8ns+ZWTi4bIsV" +
       "33jBWUNcufeuun33BT2pf7whbmKJvCFbXB5+THnlnste3r/wYGeYzB4gNXCI" +
       "Yjlx0XDRbn0zUyasOGlS7f4csAhUVKr5rtOa0XMpxpjQi6POpsIsfv3hpKv4" +
       "LrH4m1mDZkwya72R1ZNIpgnOOu5M/hzlO4JkTTOA4M44psQxjsNwDq0BvjcW" +
       "GzTN/FUrud0UPritdFePTtojXvHttP8CRt9QwxAjAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "b/F3Bdr7Ur1/3vv48TlzDD11t8sExUH5519+5VWN/QJ6cHTO20+ha2kQ/kNX" +
       "z3T3DKv7AKf33/3YlinuUpyenX715f/5BP9B86Nv4iPru/bk3Gf5ReZLv9N5" +
       "r/oTB9A9Jyept93yON/phfPnp9djPV3GPn/uFPWpE83mB6jQe8HDHGmW2T/7" +
       "O7XdnQ/+PrSz/d4x+uWC4PLxKdvzb/AbeXGQnPf54sm54RfvdHZ1j+XvPlb8" +
       "7AXH91/Oi3+XQu8o7ssApSmpfsqx8MTPv+nvF//2RHWFYz4BnuxIddnbo7qz" +
       "EH75grZfyYtfAq5r6OmZs9ZTcF95C+AeyStvgeelI3Avvf3gfvOCtq/mxWt3" +
       "OgPPG4JTkL/+Vi2Yfzb4xBHIT7z9IL9+Qdvv58XXAEhgwdtBnrHkf36rlszd" +
       "9MePQP742w/yTy9o+0Ze/HEKXVUVf6So+p79/uSt2i+PYK8cQXvl7YF26ZTg" +
       "iwXBX16A71t58ecpdF2zdgGYD/as99/fAsQiPudfkX7qCOJPvf3W+6sL2v4m" +
       "L76TQvcDF5X1ODgN0Kf4Xn8L+B7OK58EzxeO8H3hbcd36dIFbUUi87fAegAf" +
       "BVIEsMjnNS+fovu7N/XRN4WefQM3vvK7K4/fdit1d5NS/YVXb9z32KvCHxWX" +
       "nk5uO16jofsWS9c9+2n0zPuVMNYXVqGKa7sPpWGB73oKPXnR2ptCV3YvOZRL" +
       "13adHkihd96xUwrdm/87S3szhW7u06bQ5eL/WbpHgI5P6cCwu5ezJI+CdR2Q" +
       "5K+PhbvJd+l8YndilIe/l1HO5ILPnsvgiivDx9nWcndp+EX1y6/2hx97vfaF" +
       "3YUt1VW225zLfTR0dXd37CRje89duR3zutJ97rsP/uK1HzjOLh/cCXzqx2dk" +
       "e9edr0a1vDAtLjNt/9Njv/SBf//qnxWfBv8fsxZqUcstAAA=");
}
