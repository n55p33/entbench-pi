package org.apache.batik.svggen;
public class ImageHandlerBase64Encoder extends org.apache.batik.svggen.DefaultImageHandler {
    public ImageHandlerBase64Encoder() { super(); }
    public void handleHREF(java.awt.Image image, org.w3c.dom.Element imageElement,
                           org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        if (image ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_IMAGE_NULL);
        int width =
          image.
          getWidth(
            null);
        int height =
          image.
          getHeight(
            null);
        if (width ==
              0 ||
              height ==
              0) {
            handleEmptyImage(
              imageElement);
        }
        else {
            if (image instanceof java.awt.image.RenderedImage) {
                handleHREF(
                  (java.awt.image.RenderedImage)
                    image,
                  imageElement,
                  generatorContext);
            }
            else {
                java.awt.image.BufferedImage buf =
                  new java.awt.image.BufferedImage(
                  width,
                  height,
                  java.awt.image.BufferedImage.
                    TYPE_INT_ARGB);
                java.awt.Graphics2D g =
                  buf.
                  createGraphics(
                    );
                g.
                  drawImage(
                    image,
                    0,
                    0,
                    null);
                g.
                  dispose(
                    );
                handleHREF(
                  (java.awt.image.RenderedImage)
                    buf,
                  imageElement,
                  generatorContext);
            }
        }
    }
    public void handleHREF(java.awt.image.renderable.RenderableImage image,
                           org.w3c.dom.Element imageElement,
                           org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        if (image ==
              null) {
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_IMAGE_NULL);
        }
        java.awt.image.RenderedImage r =
          image.
          createDefaultRendering(
            );
        if (r ==
              null) {
            handleEmptyImage(
              imageElement);
        }
        else {
            handleHREF(
              r,
              imageElement,
              generatorContext);
        }
    }
    protected void handleEmptyImage(org.w3c.dom.Element imageElement) {
        imageElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            DATA_PROTOCOL_PNG_PREFIX);
        imageElement.
          setAttributeNS(
            null,
            SVG_WIDTH_ATTRIBUTE,
            "0");
        imageElement.
          setAttributeNS(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            "0");
    }
    public void handleHREF(java.awt.image.RenderedImage image,
                           org.w3c.dom.Element imageElement,
                           org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        java.io.ByteArrayOutputStream os =
          new java.io.ByteArrayOutputStream(
          );
        org.apache.batik.util.Base64EncoderStream b64Encoder =
          new org.apache.batik.util.Base64EncoderStream(
          os);
        try {
            encodeImage(
              image,
              b64Encoder);
            b64Encoder.
              close(
                );
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.svggen.SVGGraphics2DIOException(
              ERR_UNEXPECTED,
              e);
        }
        imageElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            DATA_PROTOCOL_PNG_PREFIX +
            os.
              toString(
                ));
    }
    public void encodeImage(java.awt.image.RenderedImage buf,
                            java.io.OutputStream os)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        try {
            org.apache.batik.ext.awt.image.spi.ImageWriter writer =
              org.apache.batik.ext.awt.image.spi.ImageWriterRegistry.
              getInstance(
                ).
              getWriterFor(
                "image/png");
            writer.
              writeImage(
                buf,
                os);
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.svggen.SVGGraphics2DIOException(
              ERR_UNEXPECTED);
        }
    }
    public java.awt.image.BufferedImage buildBufferedImage(java.awt.Dimension size) {
        return new java.awt.image.BufferedImage(
          size.
            width,
          size.
            height,
          java.awt.image.BufferedImage.
            TYPE_INT_ARGB);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1ae+wsV12f+7vtbXv7uLcttKX23QvaLv5mdvYxuxal+5qd" +
       "x75nZ3ZnBMrsvHeeO6+dHag8Io9AUokULBEaTUCBFEpUgoliSgwCAUkwjaCJ" +
       "QIyJKJLQP0RjVTwz+3vfe9s0BTeZs7Nnvud7vq/zOd85333qR9CVgQ8VPNfa" +
       "aJYb7ipJuLu0KrvhxlOCXapXGYl+oMgtSwyCKeh7RLrvc+d+8vwH9PM70BkB" +
       "ull0HDcUQ8N1gokSuFasyD3o3GFvx1LsIITO95ZiLMJRaFhwzwjCh3rQtUeG" +
       "htCF3r4IMBABBiLAuQhw45AKDLpecSK7lY0QnTBYQb8BnepBZzwpEy+E7j3O" +
       "xBN90d5jM8o1AByuzn5zQKl8cOJD9xzovtX5IoU/VIAf/503nf+j09A5ATpn" +
       "OEwmjgSECMEkAnSdrdgLxQ8asqzIAnSjoygyo/iGaBlpLrcA3RQYmiOGka8c" +
       "GCnrjDzFz+c8tNx1UqabH0mh6x+opxqKJe//ulK1RA3oesuhrlsN8awfKHjW" +
       "AIL5qigp+0OuMA1HDqG7T4440PECDQjA0KtsJdTdg6mucETQAd209Z0lOhrM" +
       "hL7haID0SjcCs4TQ7ZdlmtnaEyVT1JRHQui2k3Sj7SNAdU1uiGxICL3yJFnO" +
       "CXjp9hNeOuKfHw1e99hbHMLZyWWWFcnK5L8aDLrrxKCJoiq+4kjKduB1D/Y+" +
       "LN7yxffuQBAgfuUJ4i3NF9763MOvveuZr25pfuESNMPFUpHCR6SPL2741h2t" +
       "B+qnMzGu9tzAyJx/TPM8/Ed7Tx5KPLDybjngmD3c3X/4zOSv+Ld/WvnhDnSW" +
       "hM5IrhXZII5ulFzbMyzF7yqO4ouhIpPQNYojt/LnJHQVuO8ZjrLtHapqoIQk" +
       "dIWVd51x89/ARCpgkZnoKnBvOKq7f++JoZ7fJx4EQVeBC7oOXDC0/eTfISTD" +
       "umsrsCiJjuG48Mh3M/0DWHHCBbCtDi9A1Jtw4EY+CEHY9TVYBHGgK/sPYk1T" +
       "HJi0gfcJ0ZGBOk0xUKrljiO5suLvZtHm/T/Nk2T6nl+fOgVcccdJILDAGiJc" +
       "C9A+Ij0eNTvPffaRr+8cLIw9S4VQEUy9u516N596dzv17mWnhk6dymd8RSbC" +
       "1vHAbSYAAACN1z3AvJF683vvOw0izltfAWyekcKXR+jWIWSQOTBKIG6hZ55Y" +
       "v4N7G7ID7RyH2kxs0HU2Gz7KAPIACC+cXGKX4nvuPT/4ydMfftQ9XGzHsHsP" +
       "Ay4ema3h+04a2HclRQaoeMj+wXvEzz/yxUcv7EBXAGAAYBiKIHgBztx1co5j" +
       "a/mhfVzMdLkSKKy6vi1a2aN9MDsb6r67PuzJPX9Dfn8jsPG1WXBfAFdpL9rz" +
       "7+zpzV7WvmIbKZnTTmiR4+6vMt7HvvPNfynl5t6H6HNHNj1GCR86AgsZs3M5" +
       "ANx4GANTX1EA3T88Mfrgh370nl/PAwBQ3H+pCS9kbQvAAXAhMPO7vrr6u+99" +
       "9+PP7hwGTQj2xWhhGVJyoGTWD519ASXBbK85lAfAigWWXBY1F1jHdmVDNcSF" +
       "pWRR+t/nXl38/L89dn4bBxbo2Q+j1744g8P+VzWht3/9Tf9xV87mlJRta4c2" +
       "OyTbYuXNh5wbvi9uMjmSd/zNnR/5ivgxgLoA6QIjVXLwgnIbQLnT4Fz/B/N2" +
       "98SzYtbcHRwN/uPr60j68Yj0gWd/fD334794Lpf2eP5y1Nd90XtoG15Zc08C" +
       "2N96cqUTYqADuvIzgzect555HnAUAEcJIFkw9AFEJMciY4/6yqv+/kt/ecub" +
       "v3Ua2sGhs5YryriYLzLoGhDdSqADsEq81z+8de76atCcz1WFLlJ+GxS35b9O" +
       "AwEfuDy+4Fn6cbhEb/uvobV45z/+50VGyJHlErvuifEC/NRHb2/92g/z8YdL" +
       "PBt9V3IxCoNU7XAs+mn733fuO/PlHegqATov7eWBnGhF2cIRQO4T7CeHIFc8" +
       "9vx4HrPdtB86gLA7TsLLkWlPgssh+oP7jDq7P3sUT34KPqfA9b/ZlZk769ju" +
       "nje19rbwew72cM9LToHVeiW6i+0i2fjX51zuzdsLWfOLWzdlt78ElnWQJ6Bg" +
       "hGo4opVP/HAIQsySLuxz50BCCnxyYWlhOZtXghQ8D6dM+91tFrcFtKxFcxbb" +
       "kKhcNnx+ZUuV71w3HDLruSAhfP8/feAbv3X/94BPKejKOLM3cOWRGQdRliO/" +
       "+6kP3Xnt499/f45SAKK433z+9oczrr0X0jhrOlmD76t6e6Yqk2/8PTEI+zmw" +
       "KHKu7QuG8sg3bIC/8V4CCD960/fMj/7gM9vk7mTcniBW3vv4+366+9jjO0dS" +
       "6vsvymqPjtmm1bnQ1+9Z2IfufaFZ8hH4Pz/96J998tH3bKW66XiC2AHvP5/5" +
       "2//5xu4T3//aJXKRKyz3ZTg2vP5ZohyQjf1Prygo6JpNElN16nDcLBTmysRc" +
       "NTC73bDtiTihlotuskl03p60uyMerZQwG0tKUXUzRCPVWSwH44RASJbxzHoL" +
       "cecFlm5NaJJ0xZBjFY9HRb1OE+aKRNtIZ1XnYaaJemNPZUZhB4Vt2a6X5Dh1" +
       "lNmqOOgNMalSq9VKJVUdLrAUL9SX7ipEUpZZjkUv6ncDqSd39VLHM+dmT+cW" +
       "xSXmGog9shQaJrAqKhQDkhtvlrrOoAWDC8xJFV/1yOKS4j3bnCWUjvvtTWdj" +
       "p7jbcSPerWiraCn2K4Y1m9e9Mc7aIOv0+t0+Xlh0hEm/umC5IYlSc2TYKK9m" +
       "E7bLtCjJRHRTAjMbQ9MsJcvSRp9im15YI10kwcSiyQ7Y2ahsdaRAtI3JiqYn" +
       "02BDWV5cHXplNuQ8uztxC7RRLU6JJhYtZ6PmMFB8LDGR+sgTVuWWImhTue9x" +
       "NVhkNolMMNwGb3PVWEZWDBcTCCUD30y5gqt5ohtVDUTQkLEWVG3fZ3kCqbNM" +
       "ihSRKldWqk7L7Rtjq4NInkRpPCrJnt6v6VZTq3DFQVeeroWQQ5kizvn2Sl2S" +
       "hWDJ8mVlMTd0fCkNXVbudu22xrQ6uG7OOmu64xDGzCpulvREL3bTphfUJ501" +
       "vqqtOkG9H1pej+33OL1QRNOggy3IlqAiWJ/DWiNXCF2mKKGBoplDeqj4I5ow" +
       "qKFWLdUHnDhYtgsm0exqbKef9HlpKPfpSTgZULZRkTrCbFJaYNq4ZeMrgVoy" +
       "llCRVkjaRNwm3+xMOH8jaeNxp94DcVtpaw2E5jzJbNlpyHetjrA2+/yCbAxQ" +
       "rdugV6JdJgfuzFDYzibVLFSc45pVSjGpVBrVvVFJ9Itii5o10jY94VoC3GOT" +
       "VZtNRSbpdSiiMUz6TFWWcaKmJvOpOx43IqrSmFHNWm2ELcJN4qpzxi5T9mY6" +
       "RhpwdwlWRFLlNrWygFpzpbQAq4XneCGiZ2kqpVPHQ9Mx2C3I7rCpV2ypEgTd" +
       "9bCke1ghBhLV+gU2IIsqo7dMa45Np9oKdxikLBodpz9HeIOiBQJj2/NJpVUu" +
       "lFxpVZ6iK7EzRdrGmMFXeH3VSa35hK3Ca35K8Q28X+wM4lYojh1VbbPJFG4X" +
       "lyQ5XpVZvFjrMOPCcAjjfXtiUWW7wyT6VCaQDd3y+jAatghDGg40FOfNdtWU" +
       "DMuuLhr9Lrkw+GWXaI3JCGuIbYoKO7radUQYR4PNqtdvx0MxnGFuscVtpt2Z" +
       "4PbhyqiKMnzsjLqM6Wl0he8SfIcWqvqcK3dQyiwJQ8yL56RR77HtbtsVljTv" +
       "omuZ0oM5w/cSZMaUpV7PLdJMbNBSxST5aKCjyKLR4BuEbwfq0AcLk7Q4j2+U" +
       "+eq6v+hXSK7AdVwDGzGYEY0YQV7QtjojrCKCBjrXFPAeZxgDSxD4oYmYhdbG" +
       "axION1Dx8WQcc3S61sfurIwkMrmkyiuT1NcFnPH4GmPC3HQwUIn1uGhifb3b" +
       "cpWJqHCEVav2R4s2TCdhm6bGC0I2mIrS5tHRpFkJh2nsB2G1ObPL9bAMD1wH" +
       "TwpysV2CzeYgKrUMYVAZeUFrRRpis8KHdBVXlzjaiqYLOQ2KSgum+UXaXFWT" +
       "wULvLuPYk3CkglRZGu9grqCv/EXfKErj4sBWV3yxNmqiQapW1mQghlZlQQ6c" +
       "oDRoFJjawpkV1rLbaQxqA2HcCBTaLyNCO01KK7gQUvYCLSOr5aKC8ORy3PZq" +
       "Dl9LxKhfX9XtFpZuxp0qXZW6ajoj68qIKLT4Ju9zyKbEJ6Eb1bqttT5r23q9" +
       "VqvHFYKr1eW2Y5a9pE1jU92cUHZgrtZqcTKZdCxhUa2Zbcdq4L0aPkZK4rwZ" +
       "62xHWw1X5bHsEzXUDx2kbNVHA82UVoP2cm0v22ljU4NNFkNGxZiAKwSNylPS" +
       "x0ls4PTJZBSpPEZEch+pTY0pCY8aUS0qwGOh0NBIfNiVezbTlkobKmrUxmCB" +
       "xnN1M4jD9bQbBy1xIPAq3HOcTUVKEgC8VlqISjCcrFKlHPZMzyoV4gJGTEil" +
       "jds+K/C9mlalkmogsK3IQOd1PQlYo15v6RtCE/udNJTEfr/rC3N6XOZac66E" +
       "rZG6ahMl28FJrsqS6IrHTKKGDLsrjZCTzqqp1hA+rNf0gaMELc+1fcOn2bQa" +
       "a4lVLqiTRbGCoHRbRROyNoO7bYxFlVjyxoIWSMyoNhoFM6GO23DN35B8XU3K" +
       "mwKuufYM7+hDhaOKmDRcBaNR26S8TiEcjrsFFCMFAcawRb3QmWJpAVNsg4k5" +
       "ri1HrGS67Lzoc37DklCqOarBwoioI55CIEQJA/n2OrHTdqNgeY40mgZKarqB" +
       "WF3P1gW6FohttVitAcasyVnl+pBtSmtBGIUlGMMjrGiunHGaNHGpXOthxMCR" +
       "p/pgsw5EvUcm7ZlNRZFXwZqqo4RcVGgLmNbS+NIqHmpFNPCrK7fWZte0GVWm" +
       "objxa3M2nDZcPiVWHU0qDcuVXg/h0c0GF6aILGgsKzGu2sVDlR6xPOrDvc0E" +
       "BzunxUaDFGsYNDts2N01Wl/252V7YNEAaosFoV5vyAB4m2FIpfFYE9e8uzKd" +
       "ZE7LpUVJGrk9ps40OY+2bZIWB0NCrwqLkeVWevHc0YcERRlIs7ykDNGO1Qlf" +
       "GDLscEnrARdJHA6XK67v6+ZSpGIVwKTpa4WpjKHNatL2CDl0xhVaFekFiOwS" +
       "KVKczk+NDTyp1ZSeuSnITrpWJD0t9lyfnjgcbuEDVeijmtQ2Zbg6w/gElZsg" +
       "9PtJIdaTdEwI6/pcq81s3JX8QlGIQb7gozi5YBp00G1QurDANiuiT4XpwHai" +
       "cn+4QMguo+rpskl3Y2bIN42RQDmMgtizHt1cztC2UBsnCaJNGJhCiVkYSfPh" +
       "XAxGLD0ea6SmMhbsGmAFLsp2tVDqDPC+2yVm8746YUutaTu1BaUU9usLM+Wn" +
       "ckQPeCEW15uE4Wd6gjLr4bpTNNqso4kehYqtmTX1R1a1L07qZZQXsJJQTpfa" +
       "bNgeYOVkJnbDRjlpsFQg1eNI51lBVAx9LQP80xGDcjsebDOlSkzNw7qTKn22" +
       "OKGUDVslwgiWmmQ/5O2RX546sQj8Xtd4f9DjypNuSrk26jQ8Yi7ZI0Vnek5N" +
       "m89GjWJaxkRjs4yDSYvupQippeDNJXRSW0WJXrsz67WsCh40kyovlwernlE0" +
       "N1VpISaiNBIBpuBs34lSTpMpXqJmHFcfVqRCTGubKdWcREbbm7D6slZBZzSu" +
       "T8hetR11NnVJF6QOzMKNYDz3aMZ34lK16tQIr64YDWu+TEx4I7kWqfFiIe6m" +
       "I3u6DKlGGKzqQhCwFUodjhoDe6lOm7G50mW20pp0YYcQp3M8lKY1xTRQuYRh" +
       "TilZFUfGipLYmOg0hwOmi8y4slPW7I0R9/rLQYWbT1C44q3hESfWk5qHmyRG" +
       "oSw1xfqy1rPbY7Gb8F26OPN7+AqLnXpcqBr1Eddb91ay1ORIUh9MS1qUuLN6" +
       "tTmuh97YnWxIZTmjsUptEVPTSCTqNbjHD4xFvb7pgrx6WC1ZumgvEXvupD5i" +
       "1/vA7gQ1lyNiYxAc6Vk6B2JoWFOKMTsWB7w8iWdUUUCanTJNaeG4zqGCt0lb" +
       "AjDkuNgfJIZslwaYQvNBii021QpC4yvOQXr2vDxpwlO3W0GU0kCwkxWvGEkU" +
       "U9GUK6UmPVhMjGaLq4xkI3YqUaCAFKYQqoTFblBrNG+jUjhNgmoBwQgDXca4" +
       "6o36Q1PtbiYRP8G1SrM38OJut7qZwQN/nGy69fV4UK0qrkCVpl24DRMlsJ7g" +
       "5rxopZX2Rq1OMXLZXTca2evdG1/aG/aN+WHCQX0IvFhnD4iX8Ga5fXRv1rz6" +
       "4AAy/5w5WVM4egB5eCoFZW/Ld16u7JO/KX/8nY8/KQ8/UdzZO82bh9A1oev9" +
       "sqXEinWE1RnA6cHLnwr086rX4SnTV975r7dPf01/80s4O7/7hJwnWX6q/9TX" +
       "uq+RfnsHOn1w5nRRPe74oIeOnzSd9ZUw8p3psfOmO4+fX7fA9bo9yz506fPr" +
       "S0bBqTwKtr4/cVh6eu+EcO8QaXvuI67DbXFjv/vmrASyLkm7smvvZiVfZa86" +
       "C54VLlceYbju3hmY6+9VU3MRghMinNorguzxQ16Iny96uiEFaJscdhJJ8TK3" +
       "5UzfkjVOCJ3V83oMMengOUPmSBzPQuiK2DXkwwB3X+zo5OiRat5hXuyRN+55" +
       "5A0/F488cOARI/PIrq84MrDpwlJ2Jwe3ubOyAXHWJDnf913azNnPt+YEj2XN" +
       "u46ZLOt526F53v0yzHND1lkHl7lnHvOlmAcsdM93Q0UKFfmSVjqiTZwTfOQF" +
       "qgC/mzUfDKHzW007thduDkx2RN/HfxbhsNnTN/m5hMMdJ8JhGwOKfKkI+MSL" +
       "RcCnsub3XigCfv/lWuT14HpizyJP/GwsspMT7GQ//2DfLNtKq+HuDqPQi0Im" +
       "9BXRzkf/8YsZ4QtZ89kQulbJi7eXiounX4YVXpV1FsD1yT0rfPJnY4UTqHnT" +
       "QVy0DYDOwT4ufukFlsWXs+bPwdhFZFjgrUBVDyLpcuF2MVFuoC++FAMlIfSq" +
       "y5bOszrgbRf9Y2f7LxPps0+eu/rWJ9lv59Xjg3+CXNODrlYjyzpatjlyf8bz" +
       "FdXIFb5mW8Tx8q9vhtCtl9lqshpMfpPL/tdb+m8B/DhJH0JX5t9H6Z4F6+mQ" +
       "DrDa3hwl+XYInQYk2e13vBfdR9uKKkZWeNRkyanjidSBI256MUccyb3uP5Yx" +
       "5X+m2s9uou3fqR6Rnn6SGrzlueontnVvyRLTNONydQ+6aluCP8iQ7r0st31e" +
       "Z4gHnr/hc9e8ej+bu2Er8GH4H5Ht7ksXmXPkzsrC6Z/e+iev+8Mnv5tXmv4P" +
       "nyJ15+UmAAA=");
}
