package org.apache.batik.dom.svg;
public class SVGOMFEDistantLightElement extends org.apache.batik.dom.svg.SVGOMElement implements org.w3c.dom.svg.SVGFEDistantLightElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMElement.
                 xmlTraitInformation);
             t.put(null, SVG_AZIMUTH_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_ELEVATION_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      azimuth;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      elevation;
    protected SVGOMFEDistantLightElement() { super(
                                               );
    }
    public SVGOMFEDistantLightElement(java.lang.String prefix,
                                      org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
        initializeLiveAttributes(
          );
    }
    protected void initializeAllLiveAttributes() {
        super.
          initializeAllLiveAttributes(
            );
        initializeLiveAttributes(
          );
    }
    private void initializeLiveAttributes() {
        azimuth =
          createLiveAnimatedNumber(
            null,
            SVG_AZIMUTH_ATTRIBUTE,
            0.0F);
        elevation =
          createLiveAnimatedNumber(
            null,
            SVG_ELEVATION_ATTRIBUTE,
            0.0F);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_DISTANT_LIGHT_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getAzimuth() {
        return azimuth;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getElevation() {
        return elevation;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFEDistantLightElement(
          );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZC2wcxRmeO8fP2PEjTuI6xHk5QJxwBwUKyIHiODZxen4o" +
       "DpFqA8fe3pxv473dze6sfTGkPARKaCUUaICUQqSqQSkREFSV0opCUyFehVbi" +
       "0VJaAS2V2rQUQYRKH0Dp/8++9+42SkV60s7tzf/PP/P/883/mHvoPVJt6KSL" +
       "KizBdmnUSAwobEzQDZrtlwXD2AZ9afGeKuHDa46PXBInNRNkQV4whkXBoIMS" +
       "lbPGBFkmKQYTFJEaI5RmccSYTg2qzwhMUpUJskgyhgqaLIkSG1azFBm2C3qK" +
       "tAqM6VLGZHTIFsDIshSsJMlXkuwLk3tTpFFUtV0ee4ePvd9HQc6CN5fBSEtq" +
       "hzAjJE0mycmUZLDeok7Waaq8a0pWWYIWWWKHfKFtgi2pC0tMsOrR5o8+3pdv" +
       "4SZYKCiKyrh6xlZqqPIMzaZIs9c7INOCsZN8jVSlyHwfMyPdKWfSJEyahEkd" +
       "bT0uWH0TVcxCv8rVYY6kGk3EBTGyMihEE3ShYIsZ42sGCXXM1p0PBm1XuNpa" +
       "WpaoeNe65P57rmn5fhVpniDNkjKOyxFhEQwmmQCD0kKG6kZfNkuzE6RVgc0e" +
       "p7okyNKcvdNthjSlCMyE7XfMgp2mRnU+p2cr2EfQTTdFpuquejkOKPtXdU4W" +
       "pkDXxZ6uloaD2A8KNkiwMD0nAO7sIfOmJSXLyPLwCFfH7q8AAwytLVCWV92p" +
       "5ikCdJA2CyKyoEwlxwF6yhSwVqsAQJ2RzopC0daaIE4LUzSNiAzxjVkk4Krn" +
       "hsAhjCwKs3FJsEudoV3y7c97Ixtuv07ZrMRJDNacpaKM658Pg7pCg7bSHNUp" +
       "nANrYGNP6m5h8ZN744QA86IQs8Xz+PUnLl/fdex5i2dpGZ7RzA4qsrR4KLPg" +
       "5TP6115Shcuo01RDws0PaM5P2ZhN6S1q4GEWuxKRmHCIx7Y++9Ubj9B346Rh" +
       "iNSIqmwWAEetolrQJJnqV1CF6gKj2SFST5VsP6cPkVp4T0kKtXpHczmDsiEy" +
       "T+ZdNSr/DSbKgQg0UQO8S0pOdd41geX5e1EjhNTCQ86CZw2xPquxYSSXzKsF" +
       "mhREQZEUNTmmq6i/kQSPkwHb5pMZQP100lBNHSCYVPWppAA4yFObkFULSWMG" +
       "oLT9itHhwYFNEj/LKWkqz9A9oMdFvGn/t5mKqPPC2VgMtuOMsDOQ4RxtVuUs" +
       "1dPifnPjwIlH0i9aQMPDYVuLkfNh8oQ1eYJPnoDJEzB5ovLkJBbjc7bjIqzt" +
       "h82bBjcAvI1rx6/ecu3eVVWAO212Hlg+DqyrAvGo3/MVjoNPi0fbmuZWvnXe" +
       "03EyL0XaBJGZgozhpU+fAsclTttnuzEDkcoLGCt8AQMjna6KNAv+qlLgsKXU" +
       "qTNUx35G2n0SnHCGBzdZOZiUXT85dmD2pu03nBsn8WCMwCmrwb3h8DH07K4H" +
       "7w77hnJym/cc/+jo3btVz0sEgo4TK0tGog6rwqgImyct9qwQHks/ububm70e" +
       "vDgT4NSBg+wKzxFwQr2OQ0dd6kDhnKoXBBlJjo0bWF5XZ70eDtdW/t4OsFiA" +
       "p/JseDbax5R/I3Wxhu0SC96Is5AWPGBcOq7d/5tf/uV8bm4ntjT7koJxynp9" +
       "/gyFtXHP1erBdptOKfC9eWDsm3e9t2eSYxY4VpebsBvbfvBjsIVg5luf3/nG" +
       "228dei3u4jzGSL2mqwyOOs0WXT2RRJoi9IQJz/SWBC5RBgkInO4rFYColJOE" +
       "jEzxbH3SvOa8x/52e4sFBRl6HCStP7kAr/8LG8mNL17zjy4uJiZiSPbM5rFZ" +
       "fn6hJ7lP14VduI7iTa8s+9Zzwv0QMcBLG9Ic5Y6XcDMQvm8Xcv3P5e0FIdpF" +
       "2Kwx/PgPHjFf6pQW9732QdP2D546wVcbzL382z0saL0WwrA5swjil4T902bB" +
       "yAPfBcdGrmqRj30MEidAogg+2BjVwVMWA+Cwuatrf/uzpxdf+3IViQ+SBlkV" +
       "soMCP2ekHgBOjTw42aL25cutzZ2tg6aFq0pKlC/pQAMvL791AwWNcWPP/WjJ" +
       "DzYcPvgWB5rGRSxzwTWf2HFuiw2uLeUPEbZn8bYHm3McwNZoZgYS+RBaGyIE" +
       "hvY1brt4/N0BWTlXBjOuhJVxOYQ1ZeNMXwa8FlhzkyqaGFn4aocioDOKzUZO" +
       "uhibfmvlvf+j+bGjT7MIS3lnFcbSQLDiVZHnL4+8etGvDt9x96yVV62tHCRC" +
       "4zr+PSpnbn7nnyUw5uGhTM4XGj+RfOi+zv7L3uXjPT+No7uLpfEfYp039otH" +
       "Cn+Pr6p5Jk5qJ0iLaFch2wXZRO83AZm34ZQmUKkE6MEs2koZe904dEY4Rvim" +
       "DUcIL++Ad+TG96ZQUFiE+7IBnh4bfj1hPMcIf5ksD+k4viYA1wavdUK4bo8Q" +
       "zMjCYkHepgsSG1J4MHN3B+B7dgl8+YHdpMLxgSI1S4tQKKOX9Y4bx+dVJ8Pn" +
       "lcF4iKu62F7hxRVUz1mqY7OuNMpUGs1IrTAnFUyWd3RaH5369SlSATP1EROr" +
       "xJBeU6eo13p4LrVXdmkFvdRIvSqNhqBLZWpdTWDHdGilWsRKi96MA+6M/FND" +
       "7LLB+Q57QMtbxAL4mD1f9JuwbO6McWlZpZKQl7OHbt5/MDv6wHmWg2kLllkD" +
       "ill4+NefvpQ48PsXymTz9UzVzgFrUNm3yFqcMuDShnm17PmHNxfc+ccfd09t" +
       "PJXUG/u6TpJc4+/loERPZS8ZXspzN/+1c9tl+WtPIYteHjJnWOSDww+9cMWZ" +
       "4p1xfjVgOa6SK4XgoN6gu2rQKTN1ZVvAaa0OIvxceMZtxIyHEe4LwhXgXWlo" +
       "RCy8LYL2DWxuYWSppED2izc6tE+WU9IMdS/hDCMyfI3pUgGGzthXDsndbW9P" +
       "33f8YQuV4VgVYqZ793/9s8Tt+y2EWpc4q0vuUfxjrIscvvQWyzifwScGz3/w" +
       "Qb2wA78hIvXbtwkr3OsETcODtTJqWXyKwT8f3f3E93bvidt2up6ReTOqlPX8" +
       "xa2fR0bB+290d7kRaevgmbR3eTICIGWytFpNl8DD0VA4mx8hMQIb34mgfReb" +
       "exnp8HATBA3S93nW+vZpsFYb0rrgEW3dxJMcp4GgWRoihkao/kgE7VFsHmSk" +
       "cYqylCoK8ojtHLZ4pjhyGkyxDGl4lbXD1mfHqZui0tAIdZ+IoD2JzQ8ZaQBT" +
       "9AUTipVlgmAwi/Cs9fjpstZarqX12Xnq1qo0NMIiP4+gvYTNMxZwBvxpyk89" +
       "Uzx7GkyxEGmdXIT1KZ7EFGVCUqWhEeq+HkF7A5tXwJkpdHYEkgO3ZPSjxiVw" +
       "y7x6GiyzEmmXwHODrd4Np26ZSkMjtP9TBO04Nn8ApwsgCRcgblGR8czyzudS" +
       "9DLSWfmKFy8mOkr+X7L+ExEfOdhct+Tgla/zdNH936IREr+cKcv+Ms/3XqPp" +
       "NCdxfRutok/jXx+A3pUKEQbl+IxVQL5vcX/ISHs5buCE1s/5kY0sPycj1fzb" +
       "z/cvcGUeH1SO1ouf5ROQDiz4+qnmwLb8hYZbPTnpfsyXiNubwfdw0cn20B3i" +
       "v47ELI3/Oeikuqb192BaPHpwy8h1J770gHUdKsrC3BxKmZ8itdbNrJsur6wo" +
       "zZFVs3ntxwserV/jJEmt1oK9c7HUB94+yFA0hEtn6KLQ6HbvC984tOGpX+yt" +
       "eQXywUkSE6DUniy9VChqJtQpkymvUvH9ucxvMHvX3rvrsvW593/Hr8IIll+B" +
       "y5owf1p87fDVr97ZcagrTuYPkWoJ63R+27Fpl7KVijP6BGmSjIEiLBGkQLoz" +
       "ROpMRdpp0qFsiixAZAt4icXtYpuzye3Fy3RGVpXmtaV/QTTI6izVN6qmkkUx" +
       "TVDaeD1O2RSoOExNCw3wetytbC/VPS1uuq35J/vaqgbhdAbU8YuvNcyMW834" +
       "/8jkHVYajs0d3PcD/NOpYU1zMvC6DuseMtZs8WA/I7Ee+3YSnU3MSl2RqQ3F" +
       "xVr5Kzbt/wWDbxMMoyAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "0gf/56PTH16/9xWcQL75Ap8Xm/zX3Ke+0n27+nMHyF0nW8833W04X+mZ8xvO" +
       "1wIdRIE7Pbft/Nj5rcoyfIUjUwgXtypPjX3Hfco7nDt84g5l/zJPPg6QHzRd" +
       "ExT3SHTKtlkz1ikAAlOJgB4WFd93xtPeD5C7Y8/UTl3wF1/JUUaR8bETFdyX" +
       "Z5bg+54jFbznlagAIFf8wIxloL+sHj59h7LP5smvAOSRUz2cV0Je/q9OBf7V" +
       "VyHwQ3nm4/BVjwRWX6nNn31ZWf/tHcp+O09+EyD3rXTAeqpsD4/clTqV73Ov" +
       "Qr7H8sz8NsfmSL7N91++L96h7Et58hJArkH5qPMHEE/cAsTOnzqcquALr1YF" +
       "TxVS75/t918F//4OZf8hT35/b2L67PHFV07l+4NXId/DeeajBen+SV+pfC8P" +
       "W1+/Q9l/zZM/hmPf1ZOhp+knR7hn7XtSUIj7J69C3CfyzAZ8338k7vu//+J+" +
       "8w5lf5Un34DoBM158XDw5MBvcSrrX7yik2WAPHr7m0P5HYhHbrq2uL9qp37m" +
       "xev3vvHF2X8qLs+cXIe7yiL3GpFtnz12PfN92Q90wyzkuro/hN3HO9+G8t3u" +
       "fBAgd8G0YP1v9tR/D5DX3YoaUsL0LOU/HLnFWUqA3FP8nqX7LkSMUzqAXN5/" +
       "nCG5dABbhyT5513+sc/d+nbAyaHmcVR06Uxgc+Rgha0eejlbnVQ5ezEnD4aK" +
       "O6fHgUu0v3X6nPrZF/vD932r9sv7i0GqLe92eSv3ssiV/R2lk+Dnidu2dtzW" +
       "5d5T37n/168+eRyo3b9n+NTZz/D25ltfwaEdHxSXZnb/5o2/+a5fefHPihPD" +
       "/wfcOBzLDCwAAA==");
}
