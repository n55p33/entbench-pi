package org.apache.batik.svggen;
public abstract class AbstractImageHandlerEncoder extends org.apache.batik.svggen.DefaultImageHandler {
    private static final java.awt.geom.AffineTransform IDENTITY = new java.awt.geom.AffineTransform(
      );
    private java.lang.String imageDir = "";
    private java.lang.String urlRoot = "";
    private static java.lang.reflect.Method createGraphics = null;
    private static boolean initDone = false;
    private static final java.lang.Class[] paramc = new java.lang.Class[] { java.awt.image.BufferedImage.class };
    private static java.lang.Object[] paramo = null;
    private static java.awt.Graphics2D createGraphics(java.awt.image.BufferedImage buf) {
        if (!initDone) {
            try {
                java.lang.Class clazz =
                  java.lang.Class.
                  forName(
                    "org.apache.batik.ext.awt.image.GraphicsUtil");
                createGraphics =
                  clazz.
                    getMethod(
                      "createGraphics",
                      paramc);
                paramo =
                  (new java.lang.Object[1]);
            }
            catch (java.lang.ThreadDeath td) {
                throw td;
            }
            catch (java.lang.Throwable t) {
                
            }
            finally {
                initDone =
                  true;
            }
        }
        if (createGraphics ==
              null)
            return buf.
              createGraphics(
                );
        else {
            paramo[0] =
              buf;
            java.awt.Graphics2D g2d =
              null;
            try {
                g2d =
                  (java.awt.Graphics2D)
                    createGraphics.
                    invoke(
                      null,
                      paramo);
            }
            catch (java.lang.Exception e) {
                
            }
            return g2d;
        }
    }
    public AbstractImageHandlerEncoder(java.lang.String imageDir,
                                       java.lang.String urlRoot)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        super(
          );
        if (imageDir ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_IMAGE_DIR_NULL);
        java.io.File imageDirFile =
          new java.io.File(
          imageDir);
        if (!imageDirFile.
              exists(
                ))
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_IMAGE_DIR_DOES_NOT_EXIST);
        this.
          imageDir =
          imageDir;
        if (urlRoot !=
              null)
            this.
              urlRoot =
              urlRoot;
        else {
            try {
                this.
                  urlRoot =
                  imageDirFile.
                    toURL(
                      ).
                    toString(
                      );
            }
            catch (java.net.MalformedURLException e) {
                throw new org.apache.batik.svggen.SVGGraphics2DIOException(
                  ERR_CANNOT_USE_IMAGE_DIR +
                  e.
                    getMessage(
                      ),
                  e);
            }
        }
    }
    protected void handleHREF(java.awt.Image image, org.w3c.dom.Element imageElement,
                              org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        java.awt.Dimension size =
          new java.awt.Dimension(
          image.
            getWidth(
              null),
          image.
            getHeight(
              null));
        java.awt.image.BufferedImage buf =
          buildBufferedImage(
            size);
        java.awt.Graphics2D g =
          createGraphics(
            buf);
        g.
          drawImage(
            image,
            0,
            0,
            null);
        g.
          dispose(
            );
        saveBufferedImageToFile(
          imageElement,
          buf,
          generatorContext);
    }
    protected void handleHREF(java.awt.image.RenderedImage image,
                              org.w3c.dom.Element imageElement,
                              org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        java.awt.Dimension size =
          new java.awt.Dimension(
          image.
            getWidth(
              ),
          image.
            getHeight(
              ));
        java.awt.image.BufferedImage buf =
          buildBufferedImage(
            size);
        java.awt.Graphics2D g =
          createGraphics(
            buf);
        g.
          drawRenderedImage(
            image,
            IDENTITY);
        g.
          dispose(
            );
        saveBufferedImageToFile(
          imageElement,
          buf,
          generatorContext);
    }
    protected void handleHREF(java.awt.image.renderable.RenderableImage image,
                              org.w3c.dom.Element imageElement,
                              org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        java.awt.Dimension size =
          new java.awt.Dimension(
          (int)
            java.lang.Math.
            ceil(
              image.
                getWidth(
                  )),
          (int)
            java.lang.Math.
            ceil(
              image.
                getHeight(
                  )));
        java.awt.image.BufferedImage buf =
          buildBufferedImage(
            size);
        java.awt.Graphics2D g =
          createGraphics(
            buf);
        g.
          drawRenderableImage(
            image,
            IDENTITY);
        g.
          dispose(
            );
        saveBufferedImageToFile(
          imageElement,
          buf,
          generatorContext);
    }
    private void saveBufferedImageToFile(org.w3c.dom.Element imageElement,
                                         java.awt.image.BufferedImage buf,
                                         org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        if (generatorContext ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_CONTEXT_NULL);
        java.io.File imageFile =
          null;
        while (imageFile ==
                 null) {
            java.lang.String fileId =
              generatorContext.
                idGenerator.
              generateID(
                getPrefix(
                  ));
            imageFile =
              new java.io.File(
                imageDir,
                fileId +
                getSuffix(
                  ));
            if (imageFile.
                  exists(
                    ))
                imageFile =
                  null;
        }
        encodeImage(
          buf,
          imageFile);
        imageElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            urlRoot +
            "/" +
            imageFile.
              getName(
                ));
    }
    public abstract java.lang.String getSuffix();
    public abstract java.lang.String getPrefix();
    public abstract void encodeImage(java.awt.image.BufferedImage buf,
                                     java.io.File imageFile)
          throws org.apache.batik.svggen.SVGGraphics2DIOException;
    public abstract java.awt.image.BufferedImage buildBufferedImage(java.awt.Dimension size);
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1aC2wcxRmeOye243cc8iAP5+WkyoO7hEd4OCQ4fsXh7Bjb" +
       "WMIhOOu9OXuTvd1ld8++GAI0VRW3KoiGQGiVWJUIJE0DCQhKUQsEIV6CohLS" +
       "Uop4VyUpRBCVR9W00P+f2b3d27s9Y5rU0o73Zv755/+//59//pnZQ6fIeEMn" +
       "VVQxQ+ZWjRqhBsVsE3SDRutkwTA6oa5H3J0n/OOGE62XB0l+NynrF4wWUTBo" +
       "o0TlqNFNZkmKYQqKSI1WSqPYo02nBtUHBFNSlW4yWTKa45osiZLZokYpEnQJ" +
       "eoRMFExTl3oTJm22GJhkVgQkCTNJwrXe5poIKRFVbatDPs1FXudqQcq4M5Zh" +
       "korIZmFACCdMSQ5HJMOsSepkiabKW/tk1QzRpBnaLF9iQbAuckkGBPOOlH95" +
       "5s7+CgbBJEFRVJOpZ7RTQ5UHaDRCyp3aBpnGjRvJLSQvQopdxCapjtiDhmHQ" +
       "MAxqa+tQgfSlVEnE61SmjmlzytdEFMgkc9OZaIIuxC02bUxm4FBoWrqzzqDt" +
       "nJS2XMsMFe9eEt61+4aKR/JIeTcpl5QOFEcEIUwYpBsApfFeqhu10SiNdpOJ" +
       "Chi7g+qSIEtDlqUrDalPEcwEmN+GBSsTGtXZmA5WYEfQTU+Ipqqn1Isxh7J+" +
       "jY/JQh/oOsXRlWvYiPWgYJEEgukxAfzO6jJui6RETTLb2yOlY/XVQABdC+LU" +
       "7FdTQ41TBKggldxFZEHpC3eA6yl9QDpeBQfUTTLdlylirQniFqGP9qBHeuja" +
       "eBNQTWBAYBeTTPaSMU5gpekeK7nsc6p15R03KWuVIAmAzFEqyih/MXSq8nRq" +
       "pzGqU5gHvGPJ4sg9wpQnh4OEAPFkDzGnefzm01ctrTr6IqeZkYVmfe9mKpo9" +
       "4r7estdm1i26PA/FKNRUQ0Ljp2nOZlmb1VKT1CDCTElxxMaQ3Xi0/fnrbjtI" +
       "Pw6SomaSL6pyIg5+NFFU45okU72JKlQXTBptJhOoEq1j7c2kAN4jkkJ57fpY" +
       "zKBmMxkns6p8lf0GiGLAAiEqgndJian2uyaY/ew9qRFCKuAhk+FZRvgf+2+S" +
       "WLhfjdOwIAqKpKjhNl1F/Y0wRJxewLY/3AtevyVsqAkdXDCs6n1hAfygn9oN" +
       "A319VAnX9oKfC6LZHAcvWCsoUVCrQREhOOkh9Dft/zZSEnWeNBgIgDlmeoOB" +
       "DPNorSoDbY+4K7Gm4fRDPS9zR8PJYaFlkotg8BAfPMQGD/HBQzkGJ4EAG/M8" +
       "FIKbH4y3BcIAxOGSRR0b120anpcHfqcNjgPkkXRe2npU58QKO8D3iIcrS4fm" +
       "vrP82SAZFyGVMHJCkHF5qdX7IHCJW6y5XdILK5WzYMxxLRi40umqSKMQr/wW" +
       "DotLoTpAdaw3yXkuDvZyhhM37L+YZJWfHL138Ptdty4LkmD6GoFDjofwht3b" +
       "MLKnIni1NzZk41u+48SXh+/ZpjpRIm3RsdfKjJ6owzyvV3jh6REXzxEe63ly" +
       "WzWDfQJEcVOAWQcBsso7RloQqrEDOupSCArHVD0uyNhkY1xk9uvqoFPD3HUi" +
       "ez8P3KIYZ+VCeGRrmrL/2DpFw3Iqd2/0M48WbMG4skPb++dXT17E4LbXlnJX" +
       "UtBBzRpXPENmlSxyTXTctlOnFOjevrftrrtP7djAfBYo5mcbsBrLOohjYEKA" +
       "+Ycv3vjmu+/sOx50/NyEBT3RC3lRMqUk1pOiHErCaAsdeSAeyhAp0Guqr1XA" +
       "P6WYJPTKFCfWv8sXLH/skzsquB/IUGO70dLRGTj1568ht718w1dVjE1AxPXY" +
       "wcwh40F+ksO5VteFrShH8vvHZv3sBWEvLBcQog1piLKoG2QYBJnm0yA9Yz1x" +
       "6Q3xpRfrVzCTXsJolrHyYsTNihJWz2V+Eamjq6lJF7R+STQurG9e35AUqYai" +
       "MqaXY7HAcM+p9GnrSsd6xDuPf1ba9dlTpxkI6fmc24VaBK2Gey0WC5PAfqo3" +
       "5q0VjH6gu/ho6/UV8tEzwLEbOIoQ1431OgTLZJrDWdTjC/7yzLNTNr2WR4KN" +
       "pEhWhWijwOYumQCThhr9ELiT2uqruM8MFtqrWpKkUCMMNZLMqEC7zc7uEQ1x" +
       "zWQ2HPrN1EdX7h95hzmvxnnMYP0LcC1JC9ZsV+DEi4OvX/rH/T+9Z5DnFYv8" +
       "g6Sn37R/rZd7t3/wzwzIWXjMkvN4+neHD+2ZXrfqY9bfiVPYuzqZuf5BrHf6" +
       "Xngw/kVwXv5zQVLQTSpEKwvvEuQEzv5uyDwNOzWHTD2tPT2L5ClTTSoOz/TG" +
       "SNew3gjprLvwjtT4XuoJiuejCdfBs9yKF8u9QTFA2EsL6/I9Vi7G4gJmvjyT" +
       "FGi6BDs1kDzfYAm/CXJIiiB7otK0HKOYpLC5vqG1s7nzOntazmIuJQyaoT6q" +
       "xkO1MeBJO3VBMTDy81CN5UosWvlYq309uCklSwnWzoVnhSXLCh+Nu7NrHMDX" +
       "azy6FefgB7pJmNPUS8x5VnhE3zBG0efAU2MNVeMjei8XHYuNmYL69QZTJnS5" +
       "XVXNbHKK317OSViLSfAqa6RVPnJK2SEOMoixaPfgXJmDqUnKRJ2CI9pB2/ak" +
       "ac7SoNMYBqdQC9u+eTTcPEYNl8Kz2hJmtY+GxnfR0I8pepIimfWqQtNTXEwj" +
       "OxKQQLfpUhyyjwFr33Zh2yZxuLrtrzx2np+lA6ebfCB8e9cbm19huU0hJryd" +
       "drxwpbOQGLsSqwou9zfwF4Dna3xQXqzA/xDI6qxN2JzULgxjf84g7lEgvK3y" +
       "3S17TjzIFfBGbA8xHd71429Cd+ziCQvfys/P2E27+/DtPFcHi5tRurm5RmE9" +
       "Gj86vO23B7bt4FJVpm9MG5RE/ME//eeV0L3vvZRl/1PQq6oyFZSMbATSznT7" +
       "cKXqf1T+uzsr8xohXW4mhQlFujFBm6Pp0b3ASPS6DOYcEzgR31IPjWOSwGKw" +
       "g8f5zW/v/GzNiMBjkfL/WZz/Jz5rhuP8WHRkWSf8OGPGizsaMf3IMeXOLGnk" +
       "wF1f/PzTxn1/e4QbKdtk8RxyHNhfKL4Vf55NFhxsiPnqAn9fdQ028sD8V28d" +
       "mf8+y8YKJQOWZZgtWU5jXH0+O/Tux8dKZz3ENkLjcNJZ9ks/xso8pUo7fGKi" +
       "ljNRp6alUe3CIDv66RF/tUWu/fSyB67kSMz1Ucihf+Ka917bO3T4EPdeFMwk" +
       "S/xOHTOPOnEfmAM113nUF01XHD35YddGG/Eyaw5acbvcidusE1bvzZrFN2m2" +
       "y/0iR7wNcW9jg4AjyVTpM/sZ5S2ugbebJA8gx9fdmpPterYbk9yyQTzGPY/d" +
       "xo8pJDWUOtyExmSWCT8rzWB8TXKSyLfLdn74RHXfmrGcT2Bd1SgnEPh7Ntho" +
       "sb+NvKK8sP3v0ztX9W8aw1HDbI/je1n+suXQS00LxZ1Bdn7Ks9uMc9f0TjXp" +
       "Ua9Ip2ZCV9Lj3Hwe2HY7CdASZlvPFtDeu+DvR3O0/RqLhyGhFdHI3CdykD+R" +
       "uTnCigbNtY8KOFnksDcI3z7GDGQxPLVWqKz1CcJPfZcMxI+pHX9V1mWnNT/u" +
       "1lJz1rUN53uXUebrS99yvmJxHxb7sHguc2LizwNYHMycafj7Qe4Yz2HxSA4T" +
       "/iFH2zEsXsXicS5FDtrj/6MrPJ3DFZK5QIMkUbCOUh3Dsr9y4jmidhnWtSMn" +
       "uJbM8rtFYAnQvu27RqLr719uB+4fmGSCqWoXyHSAyi5WEzj0KTGqkD2mzc2W" +
       "GM1ep3VQGKPH+nHMffYzM7XJZFu00JpEDHOCKDuEZsKcyGHjT7D4wHffMSnF" +
       "3DlGcgz84WhzPfehC3cmD75l2FYHz7CFxo4x4BsAI2q6asKkpVEPwqU2ryw8" +
       "PQDl8RzPBqEsBQLDNIUNHroNXiSGorC3x8tOat1SQtuSXAdyfCeh6tatIlPo" +
       "THYj488rkCDAMs7PTVLUz+4V1rY3NGZb98cNqFLUsdAX59JCey009+SwEBZf" +
       "ZRpij0/X3Ibwuno7VaIpV0earxEp5tiBiaMBOhmLkjRAsWZ8CrxA6bkE72EL" +
       "gSNjB++IT9fc4C3ygKcz8DCvs3DE12xIzhkNyWosZuRCcuY5QJKdJLXC86wF" +
       "xzOjIJnlGOkZn67ZkbRxIScdcMKjgbMci8Um8BQGaFps7lQb+d2sG6kl5wCp" +
       "GdhWDc/7lrrv50DKP415yxNQJ+Xg6L/iBK7M0bYai0shiPdRswOwkphkKxx4" +
       "LjuX8HxkKfPRWYPHj2MOCK7O0daCRQOHp02nmfA0ngN4WO7VBM8pS5lTZw0e" +
       "P44eCFzp8Uk7mpXYG1ScQwyc60abiRux6DBJMWVX8naoc8++znOA3zxsQ7LP" +
       "LW0/P2v4+XHMnTBWphaCeglyFsO6DgxIOTwPLyvw4rOyNyHJ0bQw5piFQRg9" +
       "GxAmTTIjx8cUeF03LeNLLv71kfjQSHnh1JFr3+BnUvYXQiURUhhLyLL7Qsn1" +
       "nq+lplMJv15ie61AAgK3TyqHd0XsBZUImJweBK/w0sPWm/13090Eq6VDB6z4" +
       "i5vkFpPkAQm+3qqNmlfW05iQkNPASnKLz3BjzZLCyaOZyLWJmp92wsI2zvZp" +
       "SKLNOmw7PLKu9abTK+7nnxWIsjA0hFyKI6SAf+HAmOZlHNy5udm88tcuOlN2" +
       "ZMICe1s2kQvsTJEZjleSBvBqDZ1huufO3ahOXb2/uW/lU78fzj8WJIENJCBA" +
       "2r4h83IyqSVgv7ghknl63SXo7GOAmkU/37pqaezTt9j1L+GHXzP96XvE4/s3" +
       "vr5z2r6qICluJuNhx0mT7Na0fqvSTsUBvZuUSkZDEkQELpIgpx2Nl6HfCvgN" +
       "QOrYEOAsTdXiRykmmZd5M5D5KU+RrA5SfY2aUNhlUWmEFDs13DKeQ6mEpnk6" +
       "ODWWKbHcgcXNSbQGuGpPpEXT7IuTohGNzeThbNGYnRMEdrJXfLvrv1esxp+A" +
       "KwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17C8wsV33ffteva2N8jc3DMdiAbWjspd/s7OwzpoZ57s5j" +
       "57Ezuzu7bTCz89iZnefOY3dmEkhC20ATiaLEEKKApVaEtsgB0hY1VZXWUdQm" +
       "EVEkItR3A7SRSEpQQSL0Qdt0ZvZ733u/6xtIV5qzs+f8zzn/1/md/5n570vf" +
       "rN0VhbV64DvZyvHjQz2ND9dO+zDOAj06pJg2r4SRrqGOEkVSUfe8+sTnr333" +
       "ex8xH7xSu3tRe1jxPD9WYsv3orEe+c5W15jatdNa3NHdKK49yKyVrQIkseUA" +
       "jBXFzzK1V53pGteeYo5ZAAoWgIIFoGIBgE+pik6v1r3ERcseihdHm9r7awdM" +
       "7e5ALdmLa289P0ighIp7NAxfSVCMcLX8PS2EqjqnYe0tJ7LvZb5O4I/WgRd+" +
       "4T0P/sM7atcWtWuWJ5bsqAUTcTHJona/q7tLPYxgTdO1Re01nq5roh5aimPl" +
       "Fd+L2kORtfKUOAn1EyWVlUmgh9Wcp5q7Xy1lCxM19sMT8QxLd7TjX3cZjrIq" +
       "ZH39qax7CYmyvhDwPqtgLDQUVT/ucqdteVpce/PFHicyPkUXBEXXe1w9Nv2T" +
       "qe70lKKi9tDedo7irQAxDi1vVZDe5SfFLHHt0ZsOWuo6UFRbWenPx7VHLtLx" +
       "+6aC6t5KEWWXuPa6i2TVSIWVHr1gpTP2+Sb7zg//mDf0rlQ8a7rqlPxfLTo9" +
       "fqHTWDf0UPdUfd/x/meYjymv//UPXanVCuLXXSDe0/yTH//2u9/x+Mu/vad5" +
       "4w1ouOVaV+Pn1U8tH/jSm9Cn+3eUbFwN/MgqjX9O8sr9+aOWZ9OgWHmvPxmx" +
       "bDw8bnx5/K/mP/kZ/RtXaveRtbtV30ncwo9eo/puYDl6ONA9PVRiXSNr9+qe" +
       "hlbtZO2e4p6xPH1fyxlGpMdk7U6nqrrbr34XKjKKIUoV3VPcW57hH98HSmxW" +
       "92lQq9UeLK7a64qrUdt/qu+4ZgCm7+qAoiqe5fkAH/ql/BGge/Gy0K0JLAuv" +
       "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" +
       "WEQCDXzTmWJIJ29Z7a1NBLwNC24d2myK");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("INqYNdqWYLM8LHo0k0PIOl8waKZwi4yZUW7Qb+4isplvF4FIMyzn7ro8Qyd9" +
       "ZSnR9a7npTMyWsMNk8hosiPCRn0Iu8XJcshm7URze71YTTiHbS5GJKqDUdMW" +
       "tpFE4Yu1o4vIFtlgC9BMEoODFJOTl00gmQHOpNsz8nVvRpE4S6EI3AxbZg8i" +
       "s404XW27K9P2nA4kyn53wMGuPQGgbrBR9FyK+2uQqQ+Gcs73O/IWbwERtA3b" +
       "eTPsbEjUSaiENdOGK3VZpWFstqIUTZDtIpmI9gLDbQFnAnIVpE3W6QwNdLti" +
       "BS6c4xwcSZpsjTPbdRdae9TG2vSkPg7htmjMm8qENZ3JzMWJIoaDMFoXOi4e" +
       "eHaHw2az4kSorlSZFZfCIBkEfIDLUpdMJN8csLkumUt2MPfGI1wLKdlgtuEW" +
       "1KM0qMP0DobLx2hfvL3He6+pnlqeJEL+OZ5Xppc9R45rV5WjDLDTBJzqc612" +
       "IbPuzDPxM+kTtfL90mM3S36sXgR+6gMvvKhxvwwev/IJ49q9sR/8ZUff6s6Z" +
       "oe7dP40+YePxcvjy/Sp5xAZ58dH8qRZu/Vz+8gSaN53kAlSv2w+RxCgTt7Qq" +
       "La4a4KuXPNH+w7L4Dzd99/zwyeCnuTintvuPt3r6ena2Cyp6oKxEi+tDRyr6" +
       "4G2o6KCwQxD6sa7GunZDJd2xd81jOR44kaNSy4l4ZfLRDlIPNd89LPOp9aPU" +
       "56Ktflli0j47o9g096nKFQvfvrGdyp+tiuB/lsU34tp9ZpWsOBzjxA2fc299" +
       "SztV8p/8IJT8ySMlf+J2lFze/rdXot2LLjjWPe3EBUua75TFd8uhDu6+hZYO" +
       "7iuLg3NaKhu/d6KRgys/CI386pFGPv8XopGnL2gkrDRSvlk9Uk55eyP1vPZW" +
       "6nmkLK5dpp4Hvw/1VKk2bHH95pF6fuN21TO4TD0nwn7tVOInbiVxOcPBY3Ht" +
       "DZGy1c+hm+QTR/nWZ8R//PsQ/41l5VPF9bUj8b92G+Kfvt788g11cAZ2Dw4v" +
       "aSt3yIOnC4Rb6bFYiGtVozVOJXzmByHh148k/PpfkIQ/cknbO8uivZeQD/Xr" +
       "Jex8HxK+tqwcFNc3jyT85g9QwjPvpb92vNbvP06gKJ2xko+4lUuXb74P4Lj2" +
       "Kr3KVz8BgjNujHwfKniirGwV13eOVPCdH6AKLoQfD50gHWYV22d0lKF7IF1i" +
       "f7ksuKLvMrEc7dySPtVspQX+drSQxrU3XvKngDLD+ZHr/pG0/xeN+tkXr119" +
       "w4uTf7NPXDr+p8u9TO2qkTjO2czRM/d3ByfOe+8+j7TKRzh4vgCrm0QPZVJo" +
       "dVNyf/CePf0yrj14kT6u3VV9n6XTC9g/pSuG2t+cJTHj2h0FSXlrBbcMZTDd" +
       "UBLnnLLSg/Mh8rEpag/dyhRnouonz6UKVUklx2k9CX+Ut/W5Fyn2x77d+eV9" +
       "Rr/qKHlejnKVqd2z/3NBNWiZGvTWm452PNbdw6e/98Dn733bcZz+wJ7hUy8/" +
       "w9ubb5w+j7tBXCW857/2hn/8zr/34h9U2Q3/D2cExdTFNwAA");
}
