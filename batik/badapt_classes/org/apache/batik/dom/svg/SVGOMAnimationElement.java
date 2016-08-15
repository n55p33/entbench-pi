package org.apache.batik.dom.svg;
public abstract class SVGOMAnimationElement extends org.apache.batik.dom.svg.SVGOMElement implements org.w3c.dom.svg.SVGAnimationElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMElement.
                 xmlTraitInformation);
             t.put(null, SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean externalResourcesRequired;
    protected SVGOMAnimationElement() { super(); }
    protected SVGOMAnimationElement(java.lang.String prefix, org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
        initializeLiveAttributes(
          );
    }
    protected void initializeAllLiveAttributes() { super.
                                                     initializeAllLiveAttributes(
                                                       );
                                                   initializeLiveAttributes(
                                                     );
    }
    private void initializeLiveAttributes() { externalResourcesRequired =
                                                createLiveAnimatedBoolean(
                                                  null,
                                                  SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                                                  false);
    }
    public org.w3c.dom.svg.SVGElement getTargetElement() {
        return ((org.apache.batik.dom.svg.SVGAnimationContext)
                  getSVGContext(
                    )).
          getTargetElement(
            );
    }
    public float getStartTime() { return ((org.apache.batik.dom.svg.SVGAnimationContext)
                                            getSVGContext(
                                              )).
                                    getStartTime(
                                      ); }
    public float getCurrentTime() { return ((org.apache.batik.dom.svg.SVGAnimationContext)
                                              getSVGContext(
                                                )).
                                      getCurrentTime(
                                        );
    }
    public float getSimpleDuration() throws org.w3c.dom.DOMException {
        float dur =
          ((org.apache.batik.dom.svg.SVGAnimationContext)
             getSVGContext(
               )).
          getSimpleDuration(
            );
        if (dur ==
              org.apache.batik.anim.timing.TimedElement.
                INDEFINITE) {
            throw createDOMException(
                    org.w3c.dom.DOMException.
                      NOT_SUPPORTED_ERR,
                    "animation.dur.indefinite",
                    null);
        }
        return dur;
    }
    public float getHyperlinkBeginTime() {
        return ((org.apache.batik.dom.svg.SVGAnimationContext)
                  getSVGContext(
                    )).
          getHyperlinkBeginTime(
            );
    }
    public boolean beginElement() throws org.w3c.dom.DOMException {
        return ((org.apache.batik.dom.svg.SVGAnimationContext)
                  getSVGContext(
                    )).
          beginElement(
            );
    }
    public boolean beginElementAt(float offset)
          throws org.w3c.dom.DOMException {
        return ((org.apache.batik.dom.svg.SVGAnimationContext)
                  getSVGContext(
                    )).
          beginElementAt(
            offset);
    }
    public boolean endElement() throws org.w3c.dom.DOMException {
        return ((org.apache.batik.dom.svg.SVGAnimationContext)
                  getSVGContext(
                    )).
          endElement(
            );
    }
    public boolean endElementAt(float offset)
          throws org.w3c.dom.DOMException {
        return ((org.apache.batik.dom.svg.SVGAnimationContext)
                  getSVGContext(
                    )).
          endElementAt(
            offset);
    }
    public org.w3c.dom.svg.SVGAnimatedBoolean getExternalResourcesRequired() {
        return externalResourcesRequired;
    }
    public org.w3c.dom.svg.SVGStringList getRequiredFeatures() {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          getRequiredFeatures(
            this);
    }
    public org.w3c.dom.svg.SVGStringList getRequiredExtensions() {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          getRequiredExtensions(
            this);
    }
    public org.w3c.dom.svg.SVGStringList getSystemLanguage() {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          getSystemLanguage(
            this);
    }
    public boolean hasExtension(java.lang.String extension) {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          hasExtension(
            this,
            extension);
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "fyZfaH6GO/a3+CM+ffu/2zeiXxssAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "JysP2ThDEvfrnf50UMXtNsp4LSMMWp7mtYneAHUyczYRYza3e0NzPF9U+gME" +
       "iwm7mUtzPKurE4vuDuRK5tLtJjEzoYnLdciVhLiOns/nVYNwN1naLmdZNhex" +
       "lWa3ZIwdSG12BS1Hy6iFScx8SQ9IzR66Bhk5fq/V27gNjqXTWbSc+R7vlcM1" +
       "6+vzLs1RLVJKB7NGHjH4Rp5sulwF8fptk1en/HwWmFWrZrQxb0IyKU6ktK5g" +
       "xKw6XgvcnOtIKo1NxqmeixFHrtg8NPyFZRmu2e+WpVGVsmtQHHa94WY0J6xh" +
       "J6n11wSR1IfjET5ckrjgipRKoIaqTHrazI5QdWPqLYqtV3jfWJjj2Vwb8muo" +
       "lwoB17NmtWq5vqCJhmYj9ak93TgGESeT6hCyFpI5mLeC/mK4qofeiosXGtq3" +
       "CC2lucTQ5Jo4jHqVKWHLpmVJxqoy4mpTHN9s5mTmijOuqxpdnNhMh1Vv4A+1" +
       "DsFjyWgxG0/wcB4QLXkm2FAuDBe9qB0R5ZU3qrrmpF4TPbo7i+gaMTTaUxJZ" +
       "GpREBDkn0+UogjgbU4NFiGRAvTicTHjDmJOTFG4VXO4Z4YCwN0Rt3ef1YXcV" +
       "6nKy5pwwWZLalKjnedsLklFc5aJAXzBkDc35hWiaiilUCK+L6A2lx69RwRbF" +
       "JJp32UGScdzMdEZJkMHmpo6t0HxhMoMgm3GDeGAwBk2kIaREc6TZZKvJZtrQ" +
       "atPBxkuH2hqe6z1valamG79ODJHxvIemiDnqLnWRz9XxzF+zU6DRwzyc6mM6" +
       "M/wBS1pLSzAaTLk909qrseuQqOVNCcFo+vg61vOKzRDdAbOWsq60RlM4XWmr" +
       "2XTQ2Vhkbz0nxjwxY+RNuKnoMLFaDOiks+qYs37CRtXJuIx4K5qaWPMm3d7g" +
       "/SSd6Gl3aSJdo9fNPLmMLHk00EmOneArOow8vwJDmmnwPNvT7O6qRdqKyeKd" +
       "Yej4U7+/kdG4b+qIb2DV2QjOPSdemz6erPRxG56JtKqzjWpilHtoFxpUHYwU" +
       "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" +
       "DfJ+uyD/LCzdD7BPQ8EPOd1WzlLzu1TL");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("FU6A/vKtgn4aPPYetH37Qf+rG+T9XkG+HpYeBKDbke8DaRawi9SvHiP8xq0i" +
       "LG51hXuE4e1H+O9O5R1cPUE9flJ1OyxNpJLiFZPAtvK3C/IHYL4t5K7bnqV0" +
       "Il84vDxzggvfulUuFOb903su/PTt58If3yDvTwvyn8LSowBkH0w7vqU7ZkvR" +
       "dOcMcf/nWwD6yKFC/+we6M/efqDfO1vcxc/vbAv8eUHeBKYsFghPeqlTpnxe" +
       "3J07H2P/77eK/RnwvLrH/urtwX4C31eLAgd33YQBB+cLAiztwZMMwLf3pv7i" +
       "COvBwa1iLbz1Z/dYP3vb5Xzw0M1gPlKQ+8PSfYoj70GegvjA7VDlz+8hfv7/" +
       "kTifvBnOpwvyONDnY5zXCPMdt4D0qSLxR8Dz+h7p67dfmC/cIA8qyKWw9M4i" +
       "7LjZjZJnr7vcOLpGcsyV52+BK+8oEt8Lnt/ac+W3bj9XsBvkNQtSCUuPAK4c" +
       "MqGr7G71HzLjyTOYsbvbVtxYPOZD9Vb5UOR/Zc+Hr9x+PhA3yOsV5MO7ueuQ" +
       "D4WWOMF+HXfw0jFQ/FaBvgier+2Bfu32Ax3fIG9aEGofiWRBqNiU4GiRoCmn" +
       "QNK3w6t9cw/ym7cH5Amn9aEtmh+7AdIrBVkCh7YWgiNRnnJoq1sAWUzC25tt" +
       "39qD/NZbBXnTFfSBfoM8syAyiDyL1dSpy35HF/jmx1iVt3RTFJjCmdf9i4vL" +
       "j1/z56LdH2KkL7524Z63vzb7g+2N96M/rdxLle5RI8s6eYPyxPvdnq+o+pYV" +
       "9+7uU3pbfP4+qD7rYl9YugPQrV1udqWjsPS2s0qDkoCeLAmgXTxdEiy4tt8n" +
       "y30UzPnH5cLS3buXk0V+ArQOihSvP+kdusuzL/oe3UY83KzarRweP6lb2+Dw" +
       "4ZuJ6ajKydv0xR7V9p9hh/tJ0e6/YVek118jmY++Wf/87ja/ZAl5XrRyD1U6" +
       "v/tjwbbRYk/qmeu2dtjW3f0Xvv/gb977/OH+2YO7AR/r+YmxPX32vXnC9sLt" +
       "Tff8n7z9H73/V1/79vby4f8FP1UdqrI3AAA=");
}
