package org.apache.batik.svggen;
class XmlWriter implements org.apache.batik.util.SVGConstants {
    private static java.lang.String EOL;
    private static final java.lang.String TAG_END = "/>";
    private static final java.lang.String TAG_START = "</";
    private static final char[] SPACES = { ' ', ' ', ' ', ' ', ' ', ' ', ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ' };
    private static final int SPACES_LEN = SPACES.length;
    static { java.lang.String temp;
             try { temp = java.lang.System.getProperty("line.separator", "\n");
             }
             catch (java.lang.SecurityException e) {
                 temp =
                   "\n";
             }
             EOL = temp; }
    static class IndentWriter extends java.io.Writer {
        protected java.io.Writer proxied;
        protected int indentLevel;
        protected int column;
        public IndentWriter(java.io.Writer proxied) { super();
                                                      if (proxied == null)
                                                          throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                                                            org.apache.batik.svggen.ErrorConstants.
                                                              ERR_PROXY);
                                                      this.
                                                        proxied =
                                                        proxied;
        }
        public void setIndentLevel(int indentLevel) { this.
                                                        indentLevel =
                                                        indentLevel;
        }
        public int getIndentLevel() { return indentLevel;
        }
        public void printIndent() throws java.io.IOException {
            proxied.
              write(
                EOL);
            int temp =
              indentLevel;
            while (temp >
                     0) {
                if (temp >
                      SPACES_LEN) {
                    proxied.
                      write(
                        SPACES,
                        0,
                        SPACES_LEN);
                    temp -=
                      SPACES_LEN;
                }
                else {
                    proxied.
                      write(
                        SPACES,
                        0,
                        temp);
                    break;
                }
            }
            column =
              indentLevel;
        }
        public java.io.Writer getProxied() { return proxied;
        }
        public int getColumn() { return column; }
        public void write(int c) throws java.io.IOException {
            column++;
            proxied.
              write(
                c);
        }
        public void write(char[] cbuf) throws java.io.IOException {
            column +=
              cbuf.
                length;
            proxied.
              write(
                cbuf);
        }
        public void write(char[] cbuf, int off, int len) throws java.io.IOException {
            column +=
              len;
            proxied.
              write(
                cbuf,
                off,
                len);
        }
        public void write(java.lang.String str) throws java.io.IOException {
            column +=
              str.
                length(
                  );
            proxied.
              write(
                str);
        }
        public void write(java.lang.String str, int off,
                          int len) throws java.io.IOException {
            column +=
              len;
            proxied.
              write(
                str,
                off,
                len);
        }
        public void flush() throws java.io.IOException {
            proxied.
              flush(
                );
        }
        public void close() throws java.io.IOException {
            column =
              -1;
            proxied.
              close(
                );
        }
        public static final java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "Ubx0O2/zX25R972ieA+YoVzwtYdxi+b/");
        public static final java.lang.String jlc$ClassType$jl5$1 =
          ("I91//+vbmff3i+L3b2Lef3Cn5k2AKz4w7/jumPc9x6H4u0ciLX3ZuftuA/bc" +
           "/UVRuTHYc+fuFGyRQ5EfgM3vurs2SgSP3g7i40Xx0E0gPnynEHFwffIA4ifv" +
           "ujyPTXQvz2duB/a5onjqJmB/4E7BFnmEP3UA9qfuDtgTJnru5duhg4riapFC" +
           "YcehcQbdS3cD3RsH6N64++jqt0NXvCOfQ/YOLTwru+r7QZdGlYdO5uUeOuwX" +
           "bpvOC2KEp677U8A+kV3+6luXLz751uL390v8YbL5A8PKRS227ZNZYifuL/iB" +
           "qpnl5DywzxnzS7AfjypP3oSbIlemvCnYPvej+/ZUVLlytj2YqvL7ZDuwul06" +
           "bgdI7W9ONulFlXtAk+K2X0oXSfeL1FMnlaN094/dbtZP7Cy8eCq2Kv+Acfj6" +
           "Hu//gvGq/LW3+uxPvNf40j6dVralPC+oXARh0D6z9yAMOpmIdZbaIa0L3Ze/" +
           "/8gvP/DS4V7FI3uGjxX1BG/P3Th3lXb8qMw2zX/tyV/52N986w/LFJ//C+UQ" +
           "lbYZMwAA");
    }
    private static void writeXml(org.w3c.dom.Attr attr,
                                 org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                 boolean escaped)
          throws java.io.IOException { java.lang.String name =
                                         attr.
                                         getName(
                                           );
                                       out.
                                         write(
                                           name);
                                       out.
                                         write(
                                           "=\"");
                                       writeChildrenXml(
                                         attr,
                                         out,
                                         escaped);
                                       out.
                                         write(
                                           '\"');
    }
    private static void writeChildrenXml(org.w3c.dom.Attr attr,
                                         org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                         boolean escaped)
          throws java.io.IOException { char[] data =
                                         attr.
                                         getValue(
                                           ).
                                         toCharArray(
                                           );
                                       if (data ==
                                             null)
                                           return;
                                       int length =
                                         data.
                                           length;
                                       int start =
                                         0;
                                       int last =
                                         0;
                                       while (last <
                                                length) {
                                           char c =
                                             data[last];
                                           switch (c) {
                                               case '<':
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last +
                                                       1;
                                                   out.
                                                     write(
                                                       "&lt;");
                                                   break;
                                               case '>':
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last +
                                                       1;
                                                   out.
                                                     write(
                                                       "&gt;");
                                                   break;
                                               case '&':
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last +
                                                       1;
                                                   out.
                                                     write(
                                                       "&amp;");
                                                   break;
                                               case '\'':
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last +
                                                       1;
                                                   out.
                                                     write(
                                                       "&apos;");
                                                   break;
                                               case '\"':
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last +
                                                       1;
                                                   out.
                                                     write(
                                                       "&quot;");
                                                   break;
                                               default:
                                                   if (escaped &&
                                                         c >
                                                         127) {
                                                       out.
                                                         write(
                                                           data,
                                                           start,
                                                           last -
                                                             start);
                                                       java.lang.String hex =
                                                         "0000" +
                                                       java.lang.Integer.
                                                         toHexString(
                                                           c);
                                                       out.
                                                         write(
                                                           "&#x" +
                                                           hex.
                                                             substring(
                                                               hex.
                                                                 length(
                                                                   ) -
                                                                 4) +
                                                           ";");
                                                       start =
                                                         last +
                                                           1;
                                                   }
                                                   break;
                                           }
                                           last++;
                                       }
                                       out.
                                         write(
                                           data,
                                           start,
                                           last -
                                             start);
    }
    private static void writeXml(org.w3c.dom.Comment comment,
                                 org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                 boolean escaped)
          throws java.io.IOException { char[] data =
                                         comment.
                                         getData(
                                           ).
                                         toCharArray(
                                           );
                                       if (data ==
                                             null) {
                                           out.
                                             write(
                                               "<!---->");
                                           return;
                                       }
                                       out.
                                         write(
                                           "<!--");
                                       boolean sawDash =
                                         false;
                                       int length =
                                         data.
                                           length;
                                       int start =
                                         0;
                                       int last =
                                         0;
                                       while (last <
                                                length) {
                                           char c =
                                             data[last];
                                           if (c ==
                                                 '-') {
                                               if (sawDash) {
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last;
                                                   out.
                                                     write(
                                                       ' ');
                                               }
                                               sawDash =
                                                 true;
                                           }
                                           else {
                                               sawDash =
                                                 false;
                                           }
                                           last++;
                                       }
                                       out.
                                         write(
                                           data,
                                           start,
                                           last -
                                             start);
                                       if (sawDash)
                                           out.
                                             write(
                                               ' ');
                                       out.
                                         write(
                                           "-->");
    }
    private static void writeXml(org.w3c.dom.Text text,
                                 org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                 boolean escaped)
          throws java.io.IOException { writeXml(
                                         text,
                                         out,
                                         false,
                                         escaped);
    }
    private static void writeXml(org.w3c.dom.Text text,
                                 org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                 boolean trimWS,
                                 boolean escaped)
          throws java.io.IOException { char[] data =
                                         text.
                                         getData(
                                           ).
                                         toCharArray(
                                           );
                                       if (data ==
                                             null) {
                                           java.lang.System.
                                             err.
                                             println(
                                               "Null text data??");
                                           return;
                                       }
                                       int length =
                                         data.
                                           length;
                                       int start =
                                         0;
                                       int last =
                                         0;
                                       if (trimWS) {
                                           while (last <
                                                    length) {
                                               char c =
                                                 data[last];
                                               switch (c) {
                                                   case ' ':
                                                   case '\t':
                                                   case '\n':
                                                   case '\r':
                                                       last++;
                                                       continue;
                                                   default:
                                                       break;
                                               }
                                               break;
                                           }
                                           start =
                                             last;
                                       }
                                       while (last <
                                                length) {
                                           char c =
                                             data[last];
                                           switch (c) {
                                               case ' ':
                                               case '\t':
                                               case '\n':
                                               case '\r':
                                                   if (trimWS) {
                                                       int wsStart =
                                                         last;
                                                       last++;
                                                       while (last <
                                                                length) {
                                                           switch (data[last]) {
                                                               case ' ':
                                                               case '\t':
                                                               case '\n':
                                                               case '\r':
                                                                   last++;
                                                                   continue;
                                                               default:
                                                                   break;
                                                           }
                                                           break;
                                                       }
                                                       if (last ==
                                                             length) {
                                                           out.
                                                             write(
                                                               data,
                                                               start,
                                                               wsStart -
                                                                 start);
                                                           return;
                                                       }
                                                       else {
                                                           continue;
                                                       }
                                                   }
                                                   break;
                                               case '<':
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last +
                                                       1;
                                                   out.
                                                     write(
                                                       "&lt;");
                                                   break;
                                               case '>':
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last +
                                                       1;
                                                   out.
                                                     write(
                                                       "&gt;");
                                                   break;
                                               case '&':
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last +
                                                       1;
                                                   out.
                                                     write(
                                                       "&amp;");
                                                   break;
                                               default:
                                                   if (escaped &&
                                                         c >
                                                         127) {
                                                       out.
                                                         write(
                                                           data,
                                                           start,
                                                           last -
                                                             start);
                                                       java.lang.String hex =
                                                         "0000" +
                                                       java.lang.Integer.
                                                         toHexString(
                                                           c);
                                                       out.
                                                         write(
                                                           "&#x" +
                                                           hex.
                                                             substring(
                                                               hex.
                                                                 length(
                                                                   ) -
                                                                 4) +
                                                           ";");
                                                       start =
                                                         last +
                                                           1;
                                                   }
                                                   break;
                                           }
                                           last++;
                                       }
                                       out.
                                         write(
                                           data,
                                           start,
                                           last -
                                             start);
    }
    private static void writeXml(org.w3c.dom.CDATASection cdataSection,
                                 org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                 boolean escaped)
          throws java.io.IOException { char[] data =
                                         cdataSection.
                                         getData(
                                           ).
                                         toCharArray(
                                           );
                                       if (data ==
                                             null) {
                                           out.
                                             write(
                                               "<![CDATA[]]>");
                                           return;
                                       }
                                       out.
                                         write(
                                           "<![CDATA[");
                                       int length =
                                         data.
                                           length;
                                       int start =
                                         0;
                                       int last =
                                         0;
                                       while (last <
                                                length) {
                                           char c =
                                             data[last];
                                           if (c ==
                                                 ']') {
                                               if (last +
                                                     2 <
                                                     data.
                                                       length &&
                                                     data[last +
                                                            1] ==
                                                     ']' &&
                                                     data[last +
                                                            2] ==
                                                     '>') {
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last +
                                                       1;
                                                   out.
                                                     write(
                                                       "]]]]><![CDATA[>");
                                                   continue;
                                               }
                                           }
                                           last++;
                                       }
                                       out.
                                         write(
                                           data,
                                           start,
                                           last -
                                             start);
                                       out.
                                         write(
                                           "]]>");
    }
    private static void writeXml(org.w3c.dom.Element element,
                                 org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                 boolean escaped)
          throws java.io.IOException,
        org.apache.batik.svggen.SVGGraphics2DIOException {
        out.
          write(
            TAG_START,
            0,
            1);
        out.
          write(
            element.
              getTagName(
                ));
        org.w3c.dom.NamedNodeMap attributes =
          element.
          getAttributes(
            );
        if (attributes !=
              null) {
            int nAttr =
              attributes.
              getLength(
                );
            for (int i =
                   0;
                 i <
                   nAttr;
                 i++) {
                org.w3c.dom.Attr attr =
                  (org.w3c.dom.Attr)
                    attributes.
                    item(
                      i);
                out.
                  write(
                    ' ');
                writeXml(
                  attr,
                  out,
                  escaped);
            }
        }
        boolean lastElem =
          element.
          getParentNode(
            ).
          getLastChild(
            ) ==
          element;
        if (!element.
              hasChildNodes(
                )) {
            if (lastElem)
                out.
                  setIndentLevel(
                    out.
                      getIndentLevel(
                        ) -
                      2);
            out.
              printIndent(
                );
            out.
              write(
                TAG_END,
                0,
                2);
            return;
        }
        org.w3c.dom.Node child =
          element.
          getFirstChild(
            );
        out.
          printIndent(
            );
        out.
          write(
            TAG_END,
            1,
            1);
        if (child.
              getNodeType(
                ) !=
              org.w3c.dom.Node.
                TEXT_NODE ||
              element.
              getLastChild(
                ) !=
              child) {
            out.
              setIndentLevel(
                out.
                  getIndentLevel(
                    ) +
                  2);
        }
        writeChildrenXml(
          element,
          out,
          escaped);
        out.
          write(
            TAG_START,
            0,
            2);
        out.
          write(
            element.
              getTagName(
                ));
        if (lastElem)
            out.
              setIndentLevel(
                out.
                  getIndentLevel(
                    ) -
                  2);
        out.
          printIndent(
            );
        out.
          write(
            TAG_END,
            1,
            1);
    }
    private static void writeChildrenXml(org.w3c.dom.Element element,
                                         org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                         boolean escaped)
          throws java.io.IOException,
        org.apache.batik.svggen.SVGGraphics2DIOException {
        org.w3c.dom.Node child =
          element.
          getFirstChild(
            );
        while (child !=
                 null) {
            writeXml(
              child,
              out,
              escaped);
            child =
              child.
                getNextSibling(
                  );
        }
    }
    private static void writeDocumentHeader(org.apache.batik.svggen.XmlWriter.IndentWriter out)
          throws java.io.IOException { java.lang.String encoding =
                                         null;
                                       if (out.
                                             getProxied(
                                               ) instanceof java.io.OutputStreamWriter) {
                                           java.io.OutputStreamWriter osw =
                                             (java.io.OutputStreamWriter)
                                               out.
                                               getProxied(
                                                 );
                                           encoding =
                                             java2std(
                                               osw.
                                                 getEncoding(
                                                   ));
                                       }
                                       out.
                                         write(
                                           "<?xml version=\"1.0\"");
                                       if (encoding !=
                                             null) {
                                           out.
                                             write(
                                               " encoding=\"");
                                           out.
                                             write(
                                               encoding);
                                           out.
                                             write(
                                               '\"');
                                       }
                                       out.
                                         write(
                                           "?>");
                                       out.
                                         write(
                                           EOL);
                                       out.
                                         write(
                                           "<!DOCTYPE svg PUBLIC \'");
                                       out.
                                         write(
                                           SVG_PUBLIC_ID);
                                       out.
                                         write(
                                           "\'");
                                       out.
                                         write(
                                           EOL);
                                       out.
                                         write(
                                           "          \'");
                                       out.
                                         write(
                                           SVG_SYSTEM_ID);
                                       out.
                                         write(
                                           "\'");
                                       out.
                                         write(
                                           ">");
                                       out.
                                         write(
                                           EOL);
    }
    private static void writeXml(org.w3c.dom.Document document,
                                 org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                 boolean escaped)
          throws java.io.IOException,
        org.apache.batik.svggen.SVGGraphics2DIOException {
        writeDocumentHeader(
          out);
        org.w3c.dom.NodeList childList =
          document.
          getChildNodes(
            );
        writeXml(
          childList,
          out,
          escaped);
    }
    private static void writeXml(org.w3c.dom.NodeList childList,
                                 org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                 boolean escaped)
          throws java.io.IOException,
        org.apache.batik.svggen.SVGGraphics2DIOException {
        int length =
          childList.
          getLength(
            );
        if (length ==
              0)
            return;
        for (int i =
               0;
             i <
               length;
             i++) {
            org.w3c.dom.Node child =
              childList.
              item(
                i);
            writeXml(
              child,
              out,
              escaped);
            out.
              write(
                EOL);
        }
    }
    static java.lang.String java2std(java.lang.String encodingName) {
        if (encodingName ==
              null)
            return null;
        if (encodingName.
              startsWith(
                "ISO8859_"))
            return "ISO-8859-" +
            encodingName.
              substring(
                8);
        if (encodingName.
              startsWith(
                "8859_"))
            return "ISO-8859-" +
            encodingName.
              substring(
                5);
        if ("ASCII7".
              equalsIgnoreCase(
                encodingName) ||
              "ASCII".
              equalsIgnoreCase(
                encodingName))
            return "US-ASCII";
        if ("UTF8".
              equalsIgnoreCase(
                encodingName))
            return "UTF-8";
        if (encodingName.
              startsWith(
                "Unicode"))
            return "UTF-16";
        if ("SJIS".
              equalsIgnoreCase(
                encodingName))
            return "Shift_JIS";
        if ("JIS".
              equalsIgnoreCase(
                encodingName))
            return "ISO-2022-JP";
        if ("EUCJIS".
              equalsIgnoreCase(
                encodingName))
            return "EUC-JP";
        return "UTF-8";
    }
    public static void writeXml(org.w3c.dom.Node node,
                                java.io.Writer writer,
                                boolean escaped)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        try {
            org.apache.batik.svggen.XmlWriter.IndentWriter out =
              null;
            if (writer instanceof org.apache.batik.svggen.XmlWriter.IndentWriter)
                out =
                  (org.apache.batik.svggen.XmlWriter.IndentWriter)
                    writer;
            else
                out =
                  new org.apache.batik.svggen.XmlWriter.IndentWriter(
                    writer);
            switch (node.
                      getNodeType(
                        )) {
                case org.w3c.dom.Node.
                       ATTRIBUTE_NODE:
                    writeXml(
                      (org.w3c.dom.Attr)
                        node,
                      out,
                      escaped);
                    break;
                case org.w3c.dom.Node.
                       COMMENT_NODE:
                    writeXml(
                      (org.w3c.dom.Comment)
                        node,
                      out,
                      escaped);
                    break;
                case org.w3c.dom.Node.
                       TEXT_NODE:
                    writeXml(
                      (org.w3c.dom.Text)
                        node,
                      out,
                      escaped);
                    break;
                case org.w3c.dom.Node.
                       CDATA_SECTION_NODE:
                    writeXml(
                      (org.w3c.dom.CDATASection)
                        node,
                      out,
                      escaped);
                    break;
                case org.w3c.dom.Node.
                       DOCUMENT_NODE:
                    writeXml(
                      (org.w3c.dom.Document)
                        node,
                      out,
                      escaped);
                    break;
                case org.w3c.dom.Node.
                       DOCUMENT_FRAGMENT_NODE:
                    writeDocumentHeader(
                      out);
                    org.w3c.dom.NodeList childList =
                      node.
                      getChildNodes(
                        );
                    writeXml(
                      childList,
                      out,
                      escaped);
                    break;
                case org.w3c.dom.Node.
                       ELEMENT_NODE:
                    writeXml(
                      (org.w3c.dom.Element)
                        node,
                      out,
                      escaped);
                    break;
                default:
                    throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                      org.apache.batik.svggen.ErrorConstants.
                        INVALID_NODE +
                      node.
                        getClass(
                          ).
                        getName(
                          ));
            }
        }
        catch (java.io.IOException io) {
            throw new org.apache.batik.svggen.SVGGraphics2DIOException(
              io);
        }
    }
    public XmlWriter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1aC3AV1Rk+e/MkEBISHpFHgBCoIN4rID4aREMSIPSSRBLT" +
       "Nqhhs/ckWdi7u+zuTS5YRK0dqNNSpaBYkdoWC6UojlOnD6vFYUQdKY5otVbF" +
       "PmxrtbYyrdoRH/3/c3bv7t17NzE2aWbuydnz+M/5v/95zu7ht0meaZBKqlph" +
       "a5NOzXCDarWIhkljdYpomm3Q1indkSP+69o3mi4NkfwOMrZXNFdLokmXy1SJ" +
       "mR1kmqyalqhK1GyiNIYzWgxqUqNPtGRN7SATZLMxriuyJFurtRjFAe2iESXj" +
       "RMsy5K6ERRttAhaZFoWdRNhOIrX+7pooGSNp+iZ3eIVneJ2nB0fG3bVMi5RG" +
       "14t9YiRhyUokKptWTdIg5+masqlH0awwTVrh9cpiG4JV0cUZEFQ9UPLe2Vt7" +
       "SxkE5aKqahZjz1xDTU3po7EoKXFbGxQaNzeS60lOlIz2DLZIddRZNAKLRmBR" +
       "h1t3FOy+mKqJeJ3G2LEcSvm6hBuyyMx0IrpoiHGbTAvbM1AotGze2WTgdkaK" +
       "W85lBou7z4vsuuPa0gdzSEkHKZHVVtyOBJuwYJEOAJTGu6hh1sZiNNZBxqkg" +
       "7FZqyKIib7YlXWbKPapoJUD8DizYmNCpwdZ0sQI5Am9GQrI0I8VeN1Mo+ymv" +
       "WxF7gNeJLq+cw+XYDgwWybAxo1sEvbOn5G6Q1ZhFpvtnpHis/gIMgKkFcWr1" +
       "aqmlclURGkgZVxFFVHsiraB6ag8MzdNAAQ2LTA4kiljrorRB7KGdqJG+cS28" +
       "C0aNYkDgFItM8A9jlEBKk31S8sjn7aYlO65TV6ohIsCeY1RScP+jYVKlb9Ia" +
       "2k0NCnbAJ46ZF71dnPjI9hAhMHiCbzAf89OvnLlifuXRJ/mYKVnGNHetp5LV" +
       "Ke3vGvvs1Lq5l+bgNgp1zZRR+GmcMytrsXtqkjp4mIkpitgZdjqPrjn+5RsO" +
       "0bdCpKiR5EuakoiDHo2TtLguK9RYQVVqiBaNNZJRVI3Vsf5GUgD1qKxS3trc" +
       "3W1Sq5HkKqwpX2PPAFE3kECIiqAuq92aU9dFq5fVkzqx/z4Hv4hdZ/8t0hbp" +
       "1eI0IkqiKqtapMXQkH8zAh6nC7DtjXSB1m+ImFrCABWMaEZPRAQ96KVOR19P" +
       "D1UjX4orXzRk0KEwapc+QnSTyE95vyAA1FP9hq6AjazUlBg1OqVdiWUNZ+7v" +
       "fJorESq+jQR4FVgqzJcKs6XCfKlwaikiCGyF8bgkFySIYQMYNHjUMXNbr1m1" +
       "bntVDmiQ3p8LGOLQqrTIUudaveOqO6UjZcWbZ55ecCxEcqOkTJSshKhgoKg1" +
       "esAFSRtsKx3TBTHHdf0zPK4fY5ahSTQGnicoBNhUCrU+amC7RcZ7KDiBCU0w" +
       "EhwWsu6fHN3Tf2P71gtCJJTu7XHJPHBUOL0FfXTKF1f7rTwb3ZJtb7x35PYt" +
       "mmvvaeHDiXoZM5GHKr8O+OHplObNEB/qfGRLNYN9FPhjSwT7AVdX6V8jzZ3U" +
       "OK4ZeSkEhrs1Iy4q2OVgXGT1Glq/28KUcxwWE7ieogr5Nsi8+mWt+t2/Pfm3" +
       "RQxJJwCUeCJ3K7VqPE4HiZUx9zLO1cg2g1IY9+qelm/vfnvbWqaOMGJWtgWr" +
       "sawDZwPSAQS/9uTGl147vf/5UEqFSZKxMP4T+BPg9zH+sB0buJ8oq7Od1YyU" +
       "t9JxwTnulsBvKWDjqBPVV6mgfXK3LHYpFM3mw5LZCx76+45SLmUFWhwlmT84" +
       "Abf9nGXkhqevfb+SkREkjJsubO4w7ozLXcq1hiFuwn0kbzw17c4nxLvBrYMr" +
       "NeXNlHtHGwbc1IUMiwgrF/n6LsJitulV7XTr8eQ3ndKtz79T3P7Oo2fYbtMT" +
       "JK+4V4t6DVceLgVY7FxiF2neGnsn6lhOSsIeJvn900rR7AViFx5turpUOXoW" +
       "lu2AZSXwr2azAX4xmaZB9ui8gt89dmziumdzSGg5KVI0MbZcZHZGRoGCU7MX" +
       "XGpSv/wKvo/+QihKGR4kA6GMBpTC9OzybYjrFpPI5p9N+smSA/tOM23UOY0p" +
       "bD6m7FPTHCvLxV3bPvTcxb85cNvt/Tyazw12aL55FR80K103/fE/GXJhrixL" +
       "puGb3xE5vHdy3dK32HzXp+Ds6mRmZAK/7M5deCj+bqgq//EQKeggpZKd+7aL" +
       "SgLNuQPyPdNJiCE/TutPz914olKT8plT/f7Ms6zfm7kREeo4GuvFPh0sRxFW" +
       "wm+BrYML/DooEFZpZFPmsHIuFvOZ+EIWKdANGc5HsPN8k6XZyRR1piBlA1C3" +
       "SE5Dc5SNr4CDDdMiZDzMk1buYbG8GItVnHJNoJ7WpVY+x7GnhfbKCzP4EiwS" +
       "iizFh6uy85aD1dVYNFkArayKio+1igEWAGDaald0NjTV4+OVPlbah8gKArfI" +
       "XmlRVlaWRPChc1BWsOjIwkcQdYuMQj5a22rXtGXjZN0QOamH38X2WosDlK33" +
       "M3OxOIAyKGdrS21dQ2v6DQHmSq2JLtNisYMfH64effxX5g/+8iB3OFVZBvvO" +
       "JAcPFEovx4+/zieck2UCHzfhYOSb7S+uP8FSgkJMAdscq/QkeJAqelKN0hSL" +
       "U5Cj6fD7sc0i+2+Rnv8xB4dp8Ugfuh48uMtx0cJo3ALninqoMp/kpPv/r6Uw" +
       "7s0OdvQeWe374ayTW/fN+gOLgoWyCe4Q8Mty9vTMeefwa2+dKp52P0sWc1EM" +
       "tgjSD+2ZZ/K0ozaTTgkWRtLMriYthhyH3K7PVpOFLeuk7dUtTE1wHlPM83Hy" +
       "AEHNRyOypey1DXvfuI+rmj+C+QbT7btu+SS8YxdPx/iFwqyMM713Dr9U4IqX" +
       "2t3MgVZhM5b/9ciWhw9u2cZ3VZZ+PG5QE/H7XvjoRHjP75/KclLLlXrtEw06" +
       "HiF12BqfDijnqP7rJb+8tSxnOYiukRQmVHljgjbG0kNdgZno8tiVe1Phhj+b" +
       "N8x7LSLMcxIS7waY4+LStX3StsAAmK8nuhRZ4i6JkYY2hao9Fvdjm20o8d/1" +
       "EPFAsbDa71k2xGk5gbDcDYR1iqZSNBOnjx9YZS2curCCzkwGDDItLatazXTX" +
       "TVFeHbvzTz+v7lk2lJMqtlUOchbF5+mgBfOCddq/lSduenNy29LedUM4dE73" +
       "6aSf5I9WH35qxRxpZ4jdifHcKeMuLX1STboaFRnUShhquuLM4hrBpJddHQSs" +
       "3sK1YIAjxt0D9H0Xizsh45BQ9FxTBhj+/cyEHBtqdU/uLrh7uznpi9/yEON3" +
       "DfwusUPQJQHx+8Bnjt9BlC1SxON3Z7ShiU3jGLPyG5+K0YMDMMq75mAxL7Wp" +
       "1F/Q+cxzjBEc86zKuHliXrC1fUXqChyd6rSgu1HmUPfftGtfrPneBU6o2ApJ" +
       "mKXp5yu0jyqeVYtZfXd6No+p4rfsHe/wC8jFJNOTudLJksHvCKDo08wcLuhU" +
       "Ro9o9C+SwjEtHsaXIE5HeNALuupGNQYejD94JZ7NpxZ0aZpCRTW7IrCJR307" +
       "FdLlVu641cbmhqREdXRAbN7TWPzCIoX9uBPYXrb1c/s0Oeaq2sOD2dTAB2pu" +
       "v9lkeyn89tqSuGvYZHtXAMXsssXHx7A4hsXjbNlXsoOLjyfYgNNYvAAKwVCs" +
       "65WVGGTQgCa2P+Mi9+JIIYdW8ZzN56lhQ+5UAMWBraLcaxV1WjxOeUbgAfTN" +
       "wQD9Bxave9TSB+SfRwrIJvi9b7P9/rABGURxCO6lDRINH4ofDIbix1j8OxjF" +
       "d0dSHT+yef5w2FD8MICiD4ZcRioXH8+6iKVgE4oGgU0Yg0VuIGxC3gjCJrRw" +
       "mkLzcMHGKWWhOLDyVaRZcX1tW20rv/dMV0KhYjA0p2JRFoxm+UiiudHmXR82" +
       "NPUAikPwifjNQYZPFM71UQi5mznhkLkgKK+ABGyFIeq9smQurPfFeGE+FlXB" +
       "Epg1gvFc+J6N1z3DJoF7AigGxnNhrg/qzw8ANfazvFtYgsWFgwZ1YfFIwXcZ" +
       "MHnIZvbQsMEXRDHYjo8xOFYOZuirsFgGus7wqtekBGr5SirG+HsFD2R1I2nz" +
       "T9gMHh82yI4HUBzY5sd7bd6Bw6eJ7Z9KEzuwaAk24CtHEs5nbOZPDhucJwMo" +
       "DgHOJi3G3sn64Oz+VHCux2JdMJziCMCJ+QuZDEy/YjP/yhDgFLIhWTQAsWBT" +
       "vZIh0Ocb4LlxEVihAzp4ZFxoWjE2zUVn40ihswokVchp8v9DUbZbskE0bgCK" +
       "Q0i9UdmcjrHOQZqf3F3VuzkQc1vrcIfC9cFat3U4cE1aZFTqjgFfXVdkfEvI" +
       "v3+T7t9XUjhp31Uv8vcEzjdqY6KksDuhKN6Xq556vm7QbpkJYwx/1aoz3nZa" +
       "ZFJAaoLvTVkFtyzcxsfvthH2jrdIHvvvHbfHIkXuOCDFK94hd1kkB4Zgda+e" +
       "Ep97w8zfMSf5TcgUL3zsCDRhMNRTU7wfpuClL/uW07mgTfCvOTulI/tWNV13" +
       "5qJ7+YcxkiJuZncpo6OkgH9+w4jiJe/MQGoOrfyVc8+OfWDUbOeeLO3DHO/e" +
       "mOwxJ0WJT/Z9MmJWp74ceWn/kkd/vT3/VIgIa4kgQqhem/k2PqknDDJtbTTz" +
       "DUW7aLBvWWrmfmfT0vnd/3yZfe9A+H381ODxndLzB655bmfF/soQGd1I8mQ1" +
       "RpPsM4H6TeoaKvUZHaRYNhuSsEWgIotK2uuPsaicIr4wZ7jYcBanWvGLKYtU" +
       "Zb76yfzOrEjR+qmxTEuozKsVR8lot4VLxndPntB13wS3xRYlll/F4vwkSgP0" +
       "sTO6Wted745GT9aZcd6czR2za1zhCKti7YH/Ag+YWRrnLQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "0vr/eE6Y3XzCw/KHKqd+F52TOPUu+eDo");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ofpbbzgRU7424OfD46N5xVuIJy46s1W+gfjUB194UWV/Cbl0+NDYiSv3xn7w" +
       "Vx0t1ZxTs95f5p8/+/a1eEn4s4cUf/T88+ETgG7+7mH/cHiP8rmn2HfsBXL8" +
       "BrZgdFtXrqm+ew2L4/Co4totzwRdJT1V8+L9zc2egt4j+76jSV5Jx78+R8fB" +
       "WcAfOXqLQbKDTNGC4m1D2e/Xi+TzceXytpgHTH7T562pb6knCvMvbvWo9fTj" +
       "/JuB3wHXJw/B/wevPfjF7a8VyReK5N+WTb98c3yK298oG3ylSP4DkFgJRM+0" +
       "HDXUPABIUf7FE+a/9GqZLzTvPx0y/+UfnOY9clrzer7ravvXYKcw+eqtMPnj" +
       "Ivn9U8pxDos/eLVYMOD67iEW3/0hWaGgZeeB+NNbAfGtIvmTi4H4+muhFH9x" +
       "CMT3X0Mg7ixb3VncfvOE6RPO//xWnH+/SP7sYs6/8xpwfjDZ9z1gf3Aq8NgZ" +
       "c+hjAsbvT4+dVYWDu28ByMF9RXJwISAHl14LQDaHgAQ/JP9QHLK/wT8cvP7c" +
       "CJdO5vmNo2GqF61jYC0fhlJgWkpU659bdQ4eK5IrF4P44Guwwhz8o0MQ/+Fr" +
       "D2JB4xvOoXX1ZdAq6t9Utnp7kTx1y2Xm4OlXi8CPAc4/fYjAp19DBE4ZxBdK" +
       "js6foLzBYopjlAcQ0LiS5b6vJIWuEZqk7g/2neL6Xa+F8XzxkOvf/MEZz+tP" +
       "G88RR+f04d2vSB/eWyToxZbQfi0Q+Y+HiHzph4QI46vlOeBziIxeESLF4YqD" +
       "wcWI4K8CkYeLwscBEn94iMgf3gYiB6/IKIYlE8tzDU4dbjkQi4QHDBYxeS2K" +
       "1bLbCYPCq2VwBEC9vO+7/78dkb/jFYv8wfMiP6p44Gizsd+7nCiAeiFsh7Jf" +
       "F8n1i2X/vtuBJgP7wePdVHFE/LEbPtTaf1ykfPbFK5cffXH2X/anGo8+ALqX" +
       "rlzWE8c5faL3VP7uINR0qwTq3v353qDkYRNXHr1gUSwO65aZgtaDYN8+PkTy" +
       "dPu4clf5f7rdNq7cd9IODLXPnG6Sx5U7QJMi+/7gWEwnh3b2B5uz/a7wsdMa" +
       "VMZyD98K3eMup79BKE67lR/KHZ1MS/afyl1XPvfiiHn/t1u/tP8GQnGkPC9G" +
       "uUxX7tl/jlEOWpxue8uFox2NdTfx7Pce+JV733a02X9gT/CJNp+i7ambf2Qw" +
       "cIO4/Cwg/1eP/uq7/8mLXy1PLf0/IDG8Z8E4AAA=");
}
