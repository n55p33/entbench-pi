package org.apache.batik.apps.svgbrowser;
public class HistoryBrowserInterface {
    private static final java.lang.String ATTRIBUTE_ADDED_COMMAND = "Attribute added: ";
    private static final java.lang.String ATTRIBUTE_REMOVED_COMMAND = "Attribute removed: ";
    private static final java.lang.String ATTRIBUTE_MODIFIED_COMMAND = "Attribute modified: ";
    private static final java.lang.String NODE_INSERTED_COMMAND = "Node inserted: ";
    private static final java.lang.String NODE_REMOVED_COMMAND = "Node removed: ";
    private static final java.lang.String CHAR_DATA_MODIFIED_COMMAND = "Node value changed: ";
    private static final java.lang.String OUTER_EDIT_COMMAND = "Document changed outside DOM Viewer";
    private static final java.lang.String COMPOUND_TREE_NODE_DROP = "Node moved";
    private static final java.lang.String REMOVE_SELECTED_NODES = "Nodes removed";
    protected org.apache.batik.apps.svgbrowser.HistoryBrowser historyBrowser;
    protected org.apache.batik.apps.svgbrowser.AbstractCompoundCommand currentCompoundCommand;
    public HistoryBrowserInterface(org.apache.batik.apps.svgbrowser.HistoryBrowser.CommandController commandController) {
        super(
          );
        historyBrowser =
          new org.apache.batik.apps.svgbrowser.HistoryBrowser(
            commandController);
    }
    public void setCommmandController(org.apache.batik.apps.svgbrowser.HistoryBrowser.CommandController newCommandController) {
        historyBrowser.
          setCommandController(
            newCommandController);
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CompoundUpdateCommand createCompoundUpdateCommand(java.lang.String commandName) {
        org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CompoundUpdateCommand cmd =
          new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CompoundUpdateCommand(
          commandName);
        return cmd;
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CompoundUpdateCommand createNodeChangedCommand(org.w3c.dom.Node node) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CompoundUpdateCommand(
          getNodeChangedCommandName(
            node));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CompoundUpdateCommand createNodesDroppedCommand(java.util.ArrayList nodes) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CompoundUpdateCommand(
          COMPOUND_TREE_NODE_DROP);
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CompoundUpdateCommand createRemoveSelectedTreeNodesCommand(java.util.ArrayList nodes) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CompoundUpdateCommand(
          REMOVE_SELECTED_NODES);
    }
    public void performCompoundUpdateCommand(org.apache.batik.apps.svgbrowser.UndoableCommand command) {
        historyBrowser.
          addCommand(
            command);
    }
    public static class CompoundUpdateCommand extends org.apache.batik.apps.svgbrowser.AbstractCompoundCommand {
        public CompoundUpdateCommand(java.lang.String commandName) {
            super(
              );
            setName(
              commandName);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "A36s+vwqHQAA");
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowser getHistoryBrowser() {
        return historyBrowser;
    }
    public void nodeInserted(org.w3c.dom.Node newParent,
                             org.w3c.dom.Node newSibling,
                             org.w3c.dom.Node contextNode) {
        historyBrowser.
          addCommand(
            createNodeInsertedCommand(
              newParent,
              newSibling,
              contextNode));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.NodeInsertedCommand createNodeInsertedCommand(org.w3c.dom.Node newParent,
                                                                                                                  org.w3c.dom.Node newSibling,
                                                                                                                  org.w3c.dom.Node contextNode) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.NodeInsertedCommand(
          NODE_INSERTED_COMMAND +
          getBracketedNodeName(
            contextNode),
          newParent,
          newSibling,
          contextNode);
    }
    public static class NodeInsertedCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Node newSibling;
        protected org.w3c.dom.Node newParent;
        protected org.w3c.dom.Node contextNode;
        public NodeInsertedCommand(java.lang.String commandName,
                                   org.w3c.dom.Node parent,
                                   org.w3c.dom.Node sibling,
                                   org.w3c.dom.Node contextNode) {
            super(
              );
            setName(
              commandName);
            this.
              newParent =
              parent;
            this.
              contextNode =
              contextNode;
            this.
              newSibling =
              sibling;
        }
        public void execute() {  }
        public void undo() { newParent.removeChild(
                                         contextNode);
        }
        public void redo() { if (newSibling !=
                                   null) {
                                 newParent.
                                   insertBefore(
                                     contextNode,
                                     newSibling);
                             }
                             else {
                                 newParent.
                                   appendChild(
                                     contextNode);
                             } }
        public boolean shouldExecute() { if (newParent ==
                                               null ||
                                               contextNode ==
                                               null) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "Ozn3Bf7Jmov/BhadLYqdHAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "CdsLs6vi5I9v/8M3fuTpr2XXEP8LxmvRlSInAAA=");
    }
    public void nodeRemoved(org.w3c.dom.Node oldParent,
                            org.w3c.dom.Node oldSibling,
                            org.w3c.dom.Node contextNode) {
        historyBrowser.
          addCommand(
            createNodeRemovedCommand(
              oldParent,
              oldSibling,
              contextNode));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.NodeRemovedCommand createNodeRemovedCommand(org.w3c.dom.Node oldParent,
                                                                                                                org.w3c.dom.Node oldSibling,
                                                                                                                org.w3c.dom.Node contextNode) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.NodeRemovedCommand(
          NODE_REMOVED_COMMAND +
          getBracketedNodeName(
            contextNode),
          oldParent,
          oldSibling,
          contextNode);
    }
    public static class NodeRemovedCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Node oldSibling;
        protected org.w3c.dom.Node oldParent;
        protected org.w3c.dom.Node contextNode;
        public NodeRemovedCommand(java.lang.String commandName,
                                  org.w3c.dom.Node oldParent,
                                  org.w3c.dom.Node oldSibling,
                                  org.w3c.dom.Node contextNode) {
            super(
              );
            setName(
              commandName);
            this.
              oldParent =
              oldParent;
            this.
              contextNode =
              contextNode;
            this.
              oldSibling =
              oldSibling;
        }
        public void execute() {  }
        public void undo() { if (oldSibling !=
                                   null) {
                                 oldParent.
                                   insertBefore(
                                     contextNode,
                                     oldSibling);
                             }
                             else {
                                 oldParent.
                                   appendChild(
                                     contextNode);
                             } }
        public void redo() { oldParent.removeChild(
                                         contextNode);
        }
        public boolean shouldExecute() { if (oldParent ==
                                               null ||
                                               contextNode ==
                                               null) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "qMgHOfcV3mXN1X8DtLeXvJscAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public void attributeAdded(org.w3c.dom.Element contextElement,
                               java.lang.String attributeName,
                               java.lang.String newAttributeValue,
                               java.lang.String namespaceURI) {
        historyBrowser.
          addCommand(
            createAttributeAddedCommand(
              contextElement,
              attributeName,
              newAttributeValue,
              namespaceURI));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.AttributeAddedCommand createAttributeAddedCommand(org.w3c.dom.Element contextElement,
                                                                                                                      java.lang.String attributeName,
                                                                                                                      java.lang.String newAttributeValue,
                                                                                                                      java.lang.String namespaceURI) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.AttributeAddedCommand(
          ATTRIBUTE_ADDED_COMMAND +
          getBracketedNodeName(
            contextElement),
          contextElement,
          attributeName,
          newAttributeValue,
          namespaceURI);
    }
    public static class AttributeAddedCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Element contextElement;
        protected java.lang.String attributeName;
        protected java.lang.String newValue;
        protected java.lang.String namespaceURI;
        public AttributeAddedCommand(java.lang.String commandName,
                                     org.w3c.dom.Element contextElement,
                                     java.lang.String attributeName,
                                     java.lang.String newAttributeValue,
                                     java.lang.String namespaceURI) {
            super(
              );
            setName(
              commandName);
            this.
              contextElement =
              contextElement;
            this.
              attributeName =
              attributeName;
            this.
              newValue =
              newAttributeValue;
            this.
              namespaceURI =
              namespaceURI;
        }
        public void execute() {  }
        public void undo() { contextElement.
                               removeAttributeNS(
                                 namespaceURI,
                                 attributeName);
        }
        public void redo() { contextElement.
                               setAttributeNS(
                                 namespaceURI,
                                 attributeName,
                                 newValue);
        }
        public boolean shouldExecute() { if (contextElement ==
                                               null ||
                                               attributeName.
                                               length(
                                                 ) ==
                                               0) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "5J5bHQAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "JwAA");
    }
    public void attributeRemoved(org.w3c.dom.Element contextElement,
                                 java.lang.String attributeName,
                                 java.lang.String prevAttributeValue,
                                 java.lang.String namespaceURI) {
        historyBrowser.
          addCommand(
            createAttributeRemovedCommand(
              contextElement,
              attributeName,
              prevAttributeValue,
              namespaceURI));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.AttributeRemovedCommand createAttributeRemovedCommand(org.w3c.dom.Element contextElement,
                                                                                                                          java.lang.String attributeName,
                                                                                                                          java.lang.String prevAttributeValue,
                                                                                                                          java.lang.String namespaceURI) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.AttributeRemovedCommand(
          ATTRIBUTE_REMOVED_COMMAND +
          getBracketedNodeName(
            contextElement),
          contextElement,
          attributeName,
          prevAttributeValue,
          namespaceURI);
    }
    public static class AttributeRemovedCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Element contextElement;
        protected java.lang.String attributeName;
        protected java.lang.String prevValue;
        protected java.lang.String namespaceURI;
        public AttributeRemovedCommand(java.lang.String commandName,
                                       org.w3c.dom.Element contextElement,
                                       java.lang.String attributeName,
                                       java.lang.String prevAttributeValue,
                                       java.lang.String namespaceURI) {
            super(
              );
            setName(
              commandName);
            this.
              contextElement =
              contextElement;
            this.
              attributeName =
              attributeName;
            this.
              prevValue =
              prevAttributeValue;
            this.
              namespaceURI =
              namespaceURI;
        }
        public void execute() {  }
        public void undo() { contextElement.
                               setAttributeNS(
                                 namespaceURI,
                                 attributeName,
                                 prevValue);
        }
        public void redo() { contextElement.
                               removeAttributeNS(
                                 namespaceURI,
                                 attributeName);
        }
        public boolean shouldExecute() { if (contextElement ==
                                               null ||
                                               attributeName.
                                               length(
                                                 ) ==
                                               0) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "aMFgHQAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1aeawrV3mfd/NeXhKSvJeELE3J/ggkRnfssccLoSkee8az" +
           "j5fxMoYSZvWMPZtn8YxN0wJqCypSQCUBKkH+qIJaUFhUlbZqS5WqagGBkKjo" +
           "KhVQVam0FIn8UVo1bemZ8b3P9963JKGoV7rHx+d85zvf75zv+53Nz38fOhMG" +
           "UMH37PXM9qJ9PY325za6H619PdynWbQrB6GutWw5DEVQ9oT64OfP/fClD5nn" +
           "96Brp9Btsut6kRxZnhv29dCzV7rGQud2pbitO2EEnWfn8kqG48iyYdYKo8dY" +
           "6DVHmkbQBfbQBBiYAAMT4NwEuLmTAo1u0t3YaWUtZDcKl9AvQKdY6FpfzcyL" +
           "oAeOK/HlQHYO1HRzBEDDddn3EQCVN04D6P6L2LeYLwH8TAF++qPvOP/b10Dn" +
           "ptA5yx1k5qjAiAh0MoVudHRH0YOwqWm6NoVucXVdG+iBJdvWJrd7Ct0aWjNX" +
           "juJAvzhIWWHs60He527kblQzbEGsRl5wEZ5h6bZ2+O2MYcszgPWOHdYtQiIr" +
           "BwBvsIBhgSGr+mGT0wvL1SLovpMtLmK8wAAB0PSso0emd7Gr064MCqBbt3Nn" +
           "y+4MHkSB5c6A6BkvBr1E0N1XVJqNtS+rC3mmPxFBd52U626rgNT1+UBkTSLo" +
           "9pNiuSYwS3efmKUj8/N9/i1Pvcsl3b3cZk1X7cz+60Cje0806uuGHuiuqm8b" +
           "3vgo+xH5ji++fw+CgPDtJ4S3Mr/38y++9U33vvDlrcxPX0ZGUOa6Gj2hPqfc" +
           "/I3XtR5pXJOZcZ3vhVY2+ceQ5+7fPah5LPVB5N1xUWNWuX9Y+UL/z6V3f1r/" +
           "3h50AwVdq3p27AA/ukX1HN+y9aCju3ogR7pGQdfrrtbK6ynoLMizlqtvSwXD" +
           "CPWIgk7bedG1Xv4dDJEBVGRDdBbkLdfwDvO+HJl5PvUhCLoV/EN3QtDeHpT/" +
           "bT8jaAGbnqPDsiq7luvB3cDL8Iew7kYKGFsTVoDXL+DQiwPggrAXzGAZ+IGp" +
           "H1TIvh/C4WqmBF4S6gFMAjrwgjW2/UodOu9+5nT+/293aYb+fHLqFJiY152k" +
           "BRtIkZ6t6cET6tMxhr/42Se+uncxTA7GLYK6wIL9rQX7uQX7mQX7Owv2r2DB" +
           "hWYEgksBYdXXHQ+wQctzHNnVoFOncoNem1m49RIwxwvAFkDPjY8Mfo5+5/sf" +
           "vAa4p5+cBhOUicJXpvPWjl+onEVV4OTQCx9L3jP6xeIetHeclzNUoOiGrHk3" +
           "Y9OLrHnhZDxeTu+59333h5/7yJPeLjKPEf0BYVzaMgv4B0+Of+CpugYodKf+" +
           "0fvlLzzxxScv7EGnAYsA5oxk4OmAlO492cexwH/skEQzLGcAYMMLHNnOqg6Z" +
           "74bIBLOzK8kd4+Y8fwsY43NZJDwMQuLhg9DIP7Pa2/wsfe3WkbJJO4EiJ+mf" +
           "Gfif+Juv/3M5H+5DPj93ZIUc6NFjRzgkU3YuZ4tbdj4gBroO5P7+Y90PP/P9" +
           "970tdwAg8dDlOryQpcCdsgURDPMvf3n5t9/+1nPf3Ns5TQQW0VixLTW9CPK6" +
           "DNPNVwEJent4Zw/gIBsEZuY1F4au42mWYcmKrWde+l/nXl/6wr8+dX7rBzYo" +
           "OXSjN728gl35T2HQu7/6jn+/N1dzSs3WwN2Y7cS2xHrbTnMzCOR1Zkf6nr+4" +
           "59e/JH8CUDSgxdDa6DnTncnH4EyO/HawV8lbZsvd/na5O6y4LQvtpKzua56z" +
           "n21sAAdlVcVdkk88nDd4NE/3s0HL9UN5HZol94VHA+h4jB7Z7zyhfuibP7hp" +
           "9IM/fjFHfHzDdNRfONl/bOuiWXJ/CtTfeZItSDk0gVzlBf7t5+0XXgIap0Cj" +
           "CjgzFAJAaukx7zqQPnP27/7kT+945zeugfYI6AbbkzVCzgMVuh5EiB6agA9T" +
           "/2ffuvWQJHOZ8zlU6BLwW8e6K/92Fhj4yJU5isj2O7swv+s/BVt57z/8xyWD" +
           "kLPTZZb5E+2n8PMfv7v1+Pfy9juayFrfm15K9GBvuGuLfNr5t70Hr/2zPejs" +
           "FDqvHmw8R7IdZ8E3BZut8HA3Cjanx+qPb5y2u4THLtLg605S1JFuTxLUboEB" +
           "+Uw6y99wgpPy5foREKZnD8L17ElOOgXlmVbe5IE8vZAlbzikgOv9wIuAlbp2" +
           "wAI/An+nwP//ZP+Zuqxguwu4tXWwFbn/4l7EB6vfzep2W3wkOpAtF2ZpNUva" +
           "W+WNK3rN48cxvQFgufEA041XwMRdAVOW7eQDRUbQTfLhAssfjGfxhGn8qzTt" +
           "IWDSLQem3XIF08RXYhoYeX2Ve83lzBq+SrOylemOA7PuuIJZb3slZt2YOV4I" +
           "9jL6sE9dzrK3v6xluab0FPCuM8h+bT9XoFy+72uy7BvBShTmByzQwrBc2T40" +
           "5s65rV449LoROHABCrgwt2uXs4t8xXYBJrp5x/esBw43H/jHD33tgw99G9AF" +
           "DZ1ZZZMCWOLIosDH2XnvV55/5p7XPP2dD+SLKBi40S+9dPdbM62Lq6HLEiNL" +
           "Zoew7s5gDfLdKyuHEZeve7qWIbs6S3YDywHbg9XBYQZ+8tZvLz7+3c9sDyon" +
           "KfGEsP7+p3/1R/tPPb135Hj40CUntKNttkfE3OibDkY4gB64Wi95C+KfPvfk" +
           "H/7Wk+/bWnXr8cMODs7yn/mr//7a/se+85XL7KRP22A2fuyJjW7+GlkJqebh" +
           "H1uatifYcJSOCzG86BYkdcHTzSalNelKp2piWtiRBwRPsTNaSFyc681ZBDZi" +
           "2ivUDR1Oy26Zpv0R44wdeuNZFDMckg7ZWfTqUU/Ckto4GGok0ZeRTTDwgmHV" +
           "l2qWRSgdzquNcGWs641GrVCuIViBl7gaX6410NomcF2XXMVavdoQJlyb0Bey" +
           "HOLr1hSnCT02Wd/GhWGZ7C0NvGr44w61SsV0mhgNFF3phQLV8vSePZy7fI1V" +
           "N0FMBPiiigveeNovJeGiXlqFCWGZ5IjjqqVQqlBWsMYZb9KYVheM59QHpDdq" +
           "joRWb1hlPWIp4DjCdRKxPG5SlOxVm7TTcQYTq2HUvPnM8iv9aSlZC3p13Y40" +
           "Du2tq/Laxks9EVERXh132hZBVah4uaCqYxOVPUvspWxr5ppE041se6qw0Uwd" +
           "T8vmLFI2JR02hHl/kJSSxEF52xTbmwZZDZkGJREW4yGmGy1cbFCucHqvN+zz" +
           "XESIBKakRKXYpuKONCKVsacyEQPjoU+GI3qGpvR0GHTpISVRY10aey4n2axI" +
           "9P05TzGt8bgmJdOAQKQokotc2MVpVCZ9FFbHRrfUtHsNk/EJXWotkwo3wDBp" +
           "2vQMa4qlQcH1sYSjekt/ZIaJntAuMxA6bqTRxbgdhio3btcUxQBmdomOvRLr" +
           "/UlINSynI6b9iO2jrf60V1oWLJPr8bNqkZ8vEcfUSkWymYREEU9ZlcDKxCI0" +
           "ZcFisVYx4Qr9KCCjSrHZDFojWsTlYYNgCG6mtpdchcMlRzTrXBsngzVHN8dM" +
           "v9XsLAhekEaDSTVUu3WPr6QWP8AaWolOWss567Q4vzVkEWOOO63JOFjXpnRg" +
           "ILViIJYrIZvS7SXVrLbS2WTJVjcJ4xBmQ+wW0Vlb5VAOWwT2YiyozeJKbA77" +
           "zZiukjWCrtdL3XI5TfpqTNjFtayPQGiH/bKE1vAC3U2X4WojNFYrpootbWbJ" +
           "sBHLN0pzQbTdoRPb1FJqJm0QT1qbXoilmgcXcLeBlju1ZNrXe/Ulak7oAU6p" +
           "JYNmhubQDjplnIukyswb6iNqanvTLt+oNgdVXMM703g+TimanHL6qGWl3pgh" +
           "4J40oYdNXBvhaAMfop5mNuwBNw/oxgAf0qU63uFbzXHb6iLTcjLgzYU+pJvo" +
           "ptvS2dBkBHm2LE2SersSili07poCLjZkwpy0m6UWx6ReguBCxWni41RQl7Fv" +
           "GuOkAs4L8xmlmKLUrFpzOU2MzVRKtJXVlLXCqqGxi3Hkbop6i2t3Nl2jPZv1" +
           "h07apxNiybkbCdH4Yr1TXhHttl0VW2sY7/eI9pBxMKvj9CRziZNUsSVMel4L" +
           "4atwsbLsAcWtgKZbKstg2KwVImbH9/tNN6y3nBmmWoGMladheT4ZjWdtcylV" +
           "Jsls2i/a0y4S+0WKmwjNDVmYEGUbZZiAWdc7wzGOlyZ4nRMterokS8i8Pets" +
           "GsveECNIjJEXJXUcryhGlCw5cThMapUmRtBZ2BSFdsyiK1MoO/PLpWp3IaD1" +
           "Cjo2RiRRqQrdTVBxlLjFCCZPT0SaWmDY2qzarUGTb3RKhRa3cCI4aDYMo0tq" +
           "TiAASlkPS8ggLM/8tlwsLLqdGlqRVkhiNkqb0FRK0UYo2c2ujM/qHC3wgTWp" +
           "C+1Rv4jUbF4ZhOTMZChbkGwBESsxveZ6Qw7QYGEkl/x6WxoRfLvQGAjciA20" +
           "LreK7XBWDJT+vIvI0w0adDAUHXPt6qpjwPC8rG34MrJ2PMQe1tqd9qAiUQ1m" +
           "uRaao3WE16YKL62xWozMi4N6Q9W7Tc2UNz0WryAVOoqoodgjuUrcdVIbloFA" +
           "bbQo6S3RT8R1N+qQ3NId8QE1dHxx1K/MJWVsz+eVppPSs5aEyJFTXKeMLuGs" +
           "UzEFFyssjNLCn3Rhg5jN+wsS9zaSpIhWY8aodTFEPBJZ1bpp0Eo5sdJxZc3d" +
           "OAvaQSVWmusK4qh9fjhvDObBRoMLfbpMshRDsYtYdKjOZjHhsOKEqwd2LxUJ" +
           "wVkS7aknIzQyFXlsCTtJnR7MaXy5rleMSX8514RkPoL5joBaNbE8lIdJQXI5" +
           "LSIcK04KvUZlXR0EPckozBkdBWRZK1UWJTcMDFKtayy77Jcci6cduRfgPOxh" +
           "CgA4T9pat29Uu2B9mygzAve0JjWrJwEC98GiLbqxtV5SEWOsOg0rQWqsqc+k" +
           "trq0075QFRSpNxzZKs4k3RnVc23K0HngXSQuc/MJN6L7psFJzbLcIxBFh5nq" +
           "YhABti4jQT2NfJGuVtcDYsR3gJCxJnnGRBfTOSDpNBVWMNl30Vq14hNp2Jh6" +
           "mwpCdYMqajTqVmoYcMGpT1lHkxxmKNRXeNdU66pc8NXGujbXii1aDXSbm3Nm" +
           "k12144JfrFswVoopA0QWjTOBGah+fUFznB6B1RkLRrUJpS1do7ti9TXPxd58" +
           "Lnqbldr2nGjaTZNqpz+v2nSAMOUitRaWU23WIvBZqA5WCdXBW2GxHkk1R4y4" +
           "yK+nTVnl7JHY6lg01oedkiD1B6XmSGlURhPBWE1MPpKVeMy7iJM0tXUajzpB" +
           "WionC2pU8qiRoCcSLyAzUeyL5dFGxYixU0MbDdteTQqs2Eib69KktwlKRBCU" +
           "dKWnLTRdmYBD1aaMSeu1HjpOVa3IcnEGOJEpjxY4L1JywYmVGb1cYv3lgrct" +
           "1ig1kL5IxFqf94cNhhKKnQo9XLI88BNhbCpSwY0Dze15moRTQ2MabSZKW0KN" +
           "9gKOF2Liy+7ID3rA2EZEipgL+NeFy5uS1u5PaojqDyiw96xRE6sfNizMZGtR" +
           "RQjaay2amOXNxuCD1KTjoU+OY1TsEYyxrjdbqGJjNvAT30DgKuFXa8v+RBQ8" +
           "HjMqhrCYFIablTNVy2w87GKNRYTUB7U5H6N21W1bZdbuWHKHduCSxJcspTaZ" +
           "tNm4sI6CxshAJW3BdDGDXW8wb0kgsT6IO/0u2a3JbR6rUFU5maczC62Uk+Kw" +
           "xPUcAqXN0jCBV8Ekchv8vDStl5N6Vd2Qm47urGoqVu20i4jkOU7dsDaCTjaS" +
           "OroKyWGt29G4HlnH9OamBntmw29ihVmZZkpCNWUKHFlk/bKt9yqr9VIdj6vd" +
           "mhYrZUOfBKuZ3LYXmyJOSBXfi7FmIohRveXDxpAiY7uHKK7V9no2ogbjkleN" +
           "XHK2RsddPiyQAz0eCMVCj5aU+qyll9HKhiQxrweLmKEpWpTAamospLA0R21j" +
           "syERng+NJtYPBJUj03YdJ+aTQdw2+sa04aRKLMVrbiyn9fVG1xWgWJoybWvG" +
           "tNWFNwj5NlMrt5Kg2ixOVbqGtlfWsmqhjaVVqmxwvSOwzcSZGGWxota7q8Ct" +
           "jSRF98W+5rdJ0R54s0Ax4404LupaWqyR6MRIgh5TrXh4rCyiNoI1mC5LMnUB" +
           "XVFdQ1GqccVYtgLPnMPj2XDBjRupVenDmKVLdpwSJUZQC2Y7oJWOjfcoy0o2" +
           "LDoJO00UVuqUbfaxuejqbmEdoGwZroFdZAFsYlIzrhUGNbAXKPUnml+Rolhh" +
           "uYJbRiqBxIQD0xqg67I/WaUms/JEiiR4k1gtlgXYK/R60cpf9zFUrXSnkU8s" +
           "4MWgZ4ymjt6hila9XJPgWRojLi1blKGs/InXHZHtpWdya8Ep9FwMGzZbekkf" +
           "rRqbUbVANnl9xvJep9BxCgLbagxm4/p0VKwOBH9FrAfxwG2l9BrZGFVWUseI" +
           "BBdluq5rgiKgtYIgy359U6aImkVbum8Ti95GV8QR643Hfl90LCTQiW4tkIPN" +
           "dLgKA8IMmHjTLIrJZOqKmDTq+l1lQzdKlhVVJ4bIV6qxoRClqsxMKmpLaoeM" +
           "2hT5so+ixeHax8yBiayFqZ8qy/5KZooNsmBLdolJabhgjWtrO3YNEo0Lpgmj" +
           "2kDgk1q3qy0GfZavDjF8YdBgw1xokXTcL2yoht+rmoMSGw28Fk3hoks3E3vE" +
           "dz204M7bcIdBQyA0sOtiaxzwbKe3LiNtlh4PVTkNh2umMl5y6bo/38BlhRBG" +
           "rGMu55XOtD4g5lxBEfB+uVmgECK2RyMlTFp2Knam0zqSFHiFxtIJwmvIaoOU" +
           "kxUjc8SM7DWb2bH251/dzcIt+YXJxTfeH+OqJL18h3u7DnfPBfkt7y0nnwuP" +
           "3Dwduf+FssuDe670optfHDz33qef1YRPlvYO7s2TCLr24KF9p+c0UPPolW9I" +
           "uPw1e3eZ+6X3/svd4uPmO1/FM9d9J4w8qfJT3PNf6Tys/toedM3Fq91L3tmP" +
           "N3rs+IXuDYEexYErHrvWvef4U9M9YDiRg2FFTl7o7ebz8rd5b9z6w1XeJD58" +
           "lbpnsuSpCDqrp7oaR9v3sOCI46wi6PTKs7SdR33w5e5ojvaRF3zgONy7AUz0" +
           "AC76k4f7G1epey5LPgEgxa6Wv4t/dIfr2Z8Erjcf4HrzTx7XZ69S9/ks+RTA" +
           "FeiX4Pr0/wHXnVnhBYDn8QNcj//kcf3BVer+KEu+EEE3haYX2xp+ZSc9q3ie" +
           "rcvuDvfvvhrcaQTdeYUH+sPnwfqP+/IPWOyuS36EtP3hjPrZZ89dd+ezw7/O" +
           "37gv/rjleha6zoht++jD0JH8tX6gG1Y+QNdvn4n8/OPLEXT/yxkZQTfsvuTQ" +
           "vrRt/NUIuv2yjYFXZR9HZb8eQedPykbQmfzzqNw3QG87OUDx28xRkW9G0DVA" +
           "JMv+pf/Kh7qphFEgq9EQxPH2FTmfq/TU8WXoojPc+nLOcGTleujYkpP/yuxw" +
           "eYi3vzN7Qv3cszT/rhern9y+8au2vNlkWq5jobPbnxtcXGIeuKK2Q13Xko+8" +
           "dPPnr3/94Vp489bgXWQdse2+yz+o444f5U/gm9+/83fe8pvPfit/tvhfXDWv" +
           "wP4nAAA=");
    }
    public void attributeModified(org.w3c.dom.Element contextElement,
                                  java.lang.String attributeName,
                                  java.lang.String prevAttributeValue,
                                  java.lang.String newAttributeValue,
                                  java.lang.String namespaceURI) {
        historyBrowser.
          addCommand(
            createAttributeModifiedCommand(
              contextElement,
              attributeName,
              prevAttributeValue,
              newAttributeValue,
              namespaceURI));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.AttributeModifiedCommand createAttributeModifiedCommand(org.w3c.dom.Element contextElement,
                                                                                                                            java.lang.String attributeName,
                                                                                                                            java.lang.String prevAttributeValue,
                                                                                                                            java.lang.String newAttributeValue,
                                                                                                                            java.lang.String namespaceURI) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.AttributeModifiedCommand(
          ATTRIBUTE_MODIFIED_COMMAND +
          getBracketedNodeName(
            contextElement),
          contextElement,
          attributeName,
          prevAttributeValue,
          newAttributeValue,
          namespaceURI);
    }
    public static class AttributeModifiedCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Element contextElement;
        protected java.lang.String attributeName;
        protected java.lang.String prevAttributeValue;
        protected java.lang.String newAttributeValue;
        protected java.lang.String namespaceURI;
        public AttributeModifiedCommand(java.lang.String commandName,
                                        org.w3c.dom.Element contextElement,
                                        java.lang.String attributeName,
                                        java.lang.String prevAttributeValue,
                                        java.lang.String newAttributeValue,
                                        java.lang.String namespaceURI) {
            super(
              );
            setName(
              commandName);
            this.
              contextElement =
              contextElement;
            this.
              attributeName =
              attributeName;
            this.
              prevAttributeValue =
              prevAttributeValue;
            this.
              newAttributeValue =
              newAttributeValue;
            this.
              namespaceURI =
              namespaceURI;
        }
        public void execute() {  }
        public void undo() { contextElement.
                               setAttributeNS(
                                 namespaceURI,
                                 attributeName,
                                 prevAttributeValue);
        }
        public void redo() { contextElement.
                               setAttributeNS(
                                 namespaceURI,
                                 attributeName,
                                 newAttributeValue);
        }
        public boolean shouldExecute() { if (contextElement ==
                                               null ||
                                               attributeName.
                                               length(
                                                 ) ==
                                               0) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1ZfXBUVxW/u/kgCfmGkDRAgLDQCeBuaQu2E6SFNIHgJqwE" +
           "4hiE5e17d5NH3r73eO++ZJOCAjMt1FpE5Est/GM6IEMLOjLFUTppO9pWamdo" +
           "UVqdUsePEaWMZRyrI2o99763+z72I8axZiZ37957zr3nnHvO75x79+wtVKRr" +
           "qAnLJEhGVKwH22US4TQdC20Sp+sbYSzKHyvg/rz1RveDflTchyoHOL2L53Tc" +
           "IWJJ0PvQbFHWCSfzWO/GWKAcEQ3rWBviiKjIfahO1DsTqiTyIulSBEwJejkt" +
           "jGo4QjQxZhDcaS1A0OwwSBJikoRWeadbw6icV9QRm7zBQd7mmKGUCXsvnaDq" +
           "8HZuiAsZRJRCYVEnrUkNLVYVaaRfUkgQJ0lwu7TMMsG68LIMEzSfr/rwzsGB" +
           "amaCaZwsK4Spp2/AuiINYSGMquzRdgkn9B3oC6ggjKY6iAkKhFObhmDTEGya" +
           "0tamAukrsGwk2hSmDkmtVKzyVCCC5rkXUTmNS1jLRJjMsEIJsXRnzKDt3LS2" +
           "ppYZKh5ZHDp8bGv1dwtQVR+qEuUeKg4PQhDYpA8MihMxrOmrBAELfahGhsPu" +
           "wZrISeKoddK1utgvc8SA40+ZhQ4aKtbYnrat4BxBN83giaKl1Yszh7K+FcUl" +
           "rh90nWHramrYQcdBwTIRBNPiHPidxVI4KMoCQXO8HGkdA58GAmCdksBkQElv" +
           "VShzMIBqTReROLk/1AOuJ/cDaZECDqgR1JhzUWprleMHuX4cpR7poYuYU0BV" +
           "ygxBWQiq85KxleCUGj2n5DifW90rDjwqr5X9yAcyC5iXqPxTganJw7QBx7GG" +
           "IQ5MxvJF4aPcjEv7/QgBcZ2H2KR5fufth5c0jb9q0szMQrM+th3zJMqPxSqv" +
           "zGprebCAilGiKrpID9+lOYuyiDXTmlQBYWakV6STwdTk+IYff273GXzTj8o6" +
           "UTGvSEYC/KiGVxKqKGFtDZaxxhEsdKJSLAttbL4TTYF+WJSxObo+Htcx6USF" +
           "EhsqVth3MFEclqAmKoO+KMeVVF/lyADrJ1WEUC38o3qE/DsR+zM/CRoMDSgJ" +
           "HOJ4ThZlJRTRFKq/HgLEiYFtB0Ix8PrBkK4YGrhgSNH6Qxz4wQC2JjhV1UP6" +
           "UH9MU4YBDUNrAXUUbWS1+bUz5bxB6nTq/3e7JNV+2rDPBwczywsLElCtVSQB" +
           "a1H+sLG6/fZz0cumy9EwsexG0GdAgqApQZBJEKQSBG0JgjkkCKRxHbKBCDEP" +
           "x5pIcLKAfD4m0XQqoukmcMiDABewUHlLz5Z12/Y3F4B/qsOFcEKUtNmVt9ps" +
           "TEklgih/rrZidN71pS/7UWEY1XI8MTiJpqFVWj8AHD9oYUB5DDKanVjmOhIL" +
           "zYiawmMBcC1XgrFWKVGGsEbHCZruWCGV9miAh3Innazyo/Hjw3t6v3iPH/nd" +
           "uYRuWQQwSNkjNAOkkT7gxZBs61btu/HhuaO7FBtNXMkplVMzOKkOzV6f8Zon" +
           "yi+ay12IXtoVYGYvBbQnHEQnAGmTdw8XWLWmgJ/qUgIKxxUtwUl0KmXjMjIA" +
           "HmWPMGeuYf3p4BZVNHrvhjA+ZYUz+6SzM1Ta1pvOT/3MowVLLJ/qUU+8/cYf" +
           "7mPmTuWgKkfx0INJqwP36GK1DOFqbLfdqGEMdO8ej3ztyK19m5nPAsX8bBsG" +
           "aAsRQJM4mPmxV3e88971sat+288JJH4jBvVTMq1kCdWpMo+SsNtCWx7ATQnA" +
           "hHpNYJOcYGHHxSRMA+sfVQuWXnj/QLXpBxKMpNxoycQL2ON3rUa7L2/9axNb" +
           "xsfTvG3bzCYzk8E0e+VVmsaNUDmSe96c/fVXuBOQVgDKdXEUM3QuZjYoZpo3" +
           "QBnHOGmKDpopOjUxjcLR8H18UFASQVp+QfTRqeWehp3+MsZ1D2vvp5ZjmyA2" +
           "10qbBbozityB6ijUovzBqx9U9H7wwm2mtrvSczpNF6e2mn5Km4VJWL7ei3Jr" +
           "OX0A6O4f7/58tTR+B1bsgxV5AHt9vQZonHS5mEVdNOUXL748Y9uVAuTvQGWS" +
           "wgkdHItWVAphgvUBAPKk+tDDppsMU7+pZqqiDOUzBuhJzcnuA+0JlbBTG71Y" +
           "/70Vp05eZ+6qmmvMZPz0WjHLBc/svmAjxJm3PvmzU189OmxWHC25YdHD1/D3" +
           "9VJs76//lmFyBohZqiEPf1/o7NONbStvMn4bmSh3IJmZDwHdbd57zyT+4m8u" +
           "/pEfTelD1bxVn/dykkHjvQ9qUj1VtEMN75p315dmMdWaRt5ZXlR0bOvFRDsP" +
           "Q59S036FBwZZVdMCyLDHQog9Xhj0IdbpYix3s3YRbT6RQp1SVVMISIkFD/DU" +
           "5FmWoErevDE4gvABE3Jpu4I23eaCD+X0yzVuPSicP25t+HgOPXpNPWgTyRQ3" +
           "FzdBFelbaLdl1uUeaT87SWmXwD5PWvs9mUPaLXmlzcUNPqRqeChdQDHHyiby" +
           "1kmKvBg2O2htejCHyEJekXNxE3pRHJ5YYjxJiRfCXkesPY/kkHgwr8S5uAkq" +
           "pwGmQ2mLN23ozCaslEfYZPZ48tNuEFK5zm7VdkQVpuRxXT+cqdzGVEQTx+xc" +
           "N0R2ux3be/iksP6ZpSaq1rpvXe2ykXj25/98PXj8V69lKemLrRu+vWEh3c8F" +
           "4l3s5mwj4ruVh37z/UD/6smU13SsaYICmn6fAxosyp0XvKK8svePjRtXDmyb" +
           "RKU8x2NL75Lf7jr72pqF/CE/eyYwoTrjecHN1OoG6DINE0OTN7pger67Wp0N" +
           "p37BOv0LXl+2XY858uLMGjAXa54i57E8c/tos5vAJTuJeQhZPW9yjmhiAgrh" +
           "IeupIbSr9r3Bp288a7qfNxN7iPH+w1/6KHjgsOmK5uPN/Iz3EyeP+YDDxKw2" +
           "DfER/Png/1/0n+pAB+gnYGWb9YowN/2MQEsUDc3LJxbbouP353b94PSufX7L" +
           "JkmCCocUUbAhYM9EeJW/tKID7Sob3+l2hkY4yYvWiV6cvDPkYs1z4N/MM3eC" +
           "NkdBe0MW2PvJl20THPs4TXDJ0uPS5E2QizWPmqfzzJ2hzbfABBrOMMHYx2CC" +
           "ejoXAPlfsvR4afImyMWaR80Leeaep815qJXgPmFIQnsaGBzvLxT0e4yYTjxB" +
           "fm9kG78/EPmtiQh3ZWEw6epOh57qvbb9dYbeJTRdpDHTkSogrThu/dW0eco0" +
           "7BOO/lcAvWKKImFOTuvjSz8aTXfLYG7/yBNVPzxYW9ABeawTlRiyuMPAnYIb" +
           "y6foRswhlP2eayO7JREFIYJ8i1JXIuYs3/lfOAsgUUOuB7TUXfiB//ZpDozT" +
           "kPErgfmyzT93sqqk/uSmayzRp1+fy+Gs4oYkOa8kjn4xlKtxkVmm3LygqOzj" +
           "MkFzJxKSoDL7C1PtJybzGwTVZWWGGKUfTtorBFV7aQkqYp9Ouquwm00HpZDZ" +
           "cZJcI6gASGj3bfU/N/Uq8HAN6qJNAKDmkwk7q6TPXdelvaRuIi9xlILzXXmZ" +
           "/QyUcmzD/CEoyp87ua770dvLnzEftHiJGx2lq0wFdzbf1tLF0Lycq6XWKl7b" +
           "cqfyfOmCVFqsMQW28WimAzTaIdpU+obQ6Hnt0QPpR593xla88NP9xW9CBbAZ" +
           "+TiCpm3OvCQnVQOq0M3hzLCFwpE9Q7W2fGNk5ZL4n37JniGsMJ+Vmz7KXz21" +
           "5a1DDWNNfjS1ExVBxsdJdnt/ZETegPkhrQ9ViHp7EkSEVUROcmFCJfV+jr4+" +
           "MbtY5qxIj9LnUIKaMyuZzEfkMkkZxtpqBdKrhSpT7RHX71NWRJUZquphsEcc" +
           "0DhuAhE9DfDbaLhLVVOVke93KgOTF73YyAYZ903Wpc37/wbtEY7WIh4AAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL16e+zr1n0f77V9/ajte+00sefFjpPcpnUU/CiJkijBTRZS" +
           "pETxIYriQ6La1eFLIsWn+JAotu6atE2CBciMzs6yIfVfCbp2aZMNMxpg8+C2" +
           "2NqiRYcWbde1W1MMA9atC9D8sW5ounWH1O99H7azYAJ0RJ3H93y+53y/n+95" +
           "8MvfgO5LYqgWhd5+5YXpkZWnR2uvfZTuIys5otn2RIsTy+x7WpJIIO8F431f" +
           "vf4X33rJvnEVuraA3qEFQZhqqRMGydRKQm9rmSx0/SyX9Cw/SaEb7FrbanCW" +
           "Oh7MOkn6PAt917mmKXSTPYEAAwgwgABXEGDsrBZo9IgVZH6/bKEFabKBfhS6" +
           "wkLXIqOEl0LvvSgk0mLNPxYzqTQAEh4o/ytAqapxHkPPnup+0PkWhV+pwS//" +
           "gx+68c/uga4voOtOIJZwDAAiBZ0soId9y9etOMFM0zIX0GOBZZmiFTua5xQV" +
           "7gX0eOKsAi3NYut0kMrMLLLiqs+zkXvYKHWLMyMN41P1lo7lmSf/7lt62gro" +
           "+q4zXQ8aDsp8oOBDDgAWLzXDOmlyr+sEZgq953KLUx1vMqACaHq/b6V2eNrV" +
           "vYEGMqDHD3PnacEKFtPYCVag6n1hBnpJoafuKLQc60gzXG1lvZBCT16uNzkU" +
           "gVoPVgNRNkmhd16uVkkCs/TUpVk6Nz/fGH//Z384oIKrFWbTMrwS/wOg0TOX" +
           "Gk2tpRVbgWEdGj78QfZz2rte//RVCAKV33mp8qHOL/7INz/6oWfe+LVDnb95" +
           "mzq8vraM9AXji/qjv/3u/nO9e0oYD0Rh4pSTf0HzyvwnxyXP5xHwvHedSiwL" +
           "j04K35j+G/XHfs76s6vQQyPomhF6mQ/s6DEj9CPHs+KhFVixllrmCHrQCsx+" +
           "VT6C7gfPrBNYh1x+uUysdATd61VZ18LqPxiiJRBRDtH94NkJluHJc6SldvWc" +
           "RxAEPQ6+0BMQdPVHoOpz+E0hF7ZD34I1QwucIIQncVjqn8BWkOpgbG1YB1bv" +
           "wkmYxcAE4TBewRqwA9s6LtCiKIGT7UqPw11ixTAF6CCM9/jh7+jEeI9Ko4v+" +
           "/3aXl9rf2F25Aibm3ZdpwQO1qNAzrfgF4+UMJ7/5Cy/8xtVTNzketxQSAIKj" +
           "A4KjCsFRieDoDMHRHRDcxFLgXDpwKy40HeDzYFp9XwtM6MqVCtF3lxAPZgIm" +
           "2QV0AQQ9/Jz4t+mPffp99wD7jHb3ghkqq8J35vP+GcGMKho1gJVDb3x+93Hl" +
           "79SvQlcvEnOpFsh6qGw+Ken0lDZvXnbI28m9/qk//YuvfO7F8Mw1LzD9MWPc" +
           "2rL0+PddnoA4NCwTcOiZ+A8+q732wusv3rwK3QtoBFBnqgFTB6z0zOU+Lnj+" +
           "8ycsWupyH1B4Gca+5pVFJ9T3UGqD6TnLqSzj0er5MTDG10tX+F7gEz9z7BvV" +
           "b1n6jqhMv/tgSeWkXdKiYukPi9FP/8Fv/VekGu4TQr9+LkSKVvr8ORIphV2v" +
           "6OKxMxuQYssC9f7j5yd//5VvfOoHKgMANd5/uw5vlikwpzIigmH+yV/b/Puv" +
           "//EXf/fqmdGkIIpmuucY+amSD5Q6PXoXJUFvHzjDA0jIA55ZWs1NOfArG9Z0" +
           "zyqt9K+uf0/jtf/+2RsHO/BAzokZfejNBZzl/w0c+rHf+KH/+Uwl5opRBsGz" +
           "MTurdmDWd5xJxuJY25c48o//ztP/8Fe1nwYcDXgxcQqrorpr1RhcqzR/J1is" +
           "VC3LeHd0iHcnBe8ofXuHGEdm6B+VKxtAQmVR/VJSzT5ctfpglR6VI1d1AlVl" +
           "7TJ5T3Leiy466rlVzwvGS7/7548of/6vvlmpfXHZdN5oOC16/mCnZfJsDsQ/" +
           "cZkyKC2xQb3WG+MfvOG98S0gcQEkGoA5Ez4G1JZfMLHj2vfd/4e/9Cvv+thv" +
           "3wNdHUAPeaFmDrTKW6EHgZtYiQ1YMY/+1kcPZrIr7eZGpSp0i/IH63qy+vcA" +
           "APjcnYlqUK56znz9yb/kPf0T/+l/3TIIFUXdJthfar+Av/yFp/of+bOq/RlX" +
           "lK2fyW+le7BCPGvb/Dn/f1x937V/fRW6fwHdMI6Xn4rmZaUHLsCSKzlZk4Il" +
           "6oXyi8unw1rh+VMufPdlnjrX7WWWOgsz4LmsXT4/dImYqqD9HPDVjx/77Mcv" +
           "E9MVqHroV03eW6U3y+R7T3jgwSgOU4DSMo+p4K/B5wr4/p/yW4orMw5rgcf7" +
           "xwuSZ09XJBGIgY8ah8XxORdpHgixTDtlQhyE9+5oNR+5qFNJtp881umTd9CJ" +
           "u4NO5eOwGigqhR7RTsLs+Hg865egjd8mtA8BSJ85hvaZO0CT3gq0x6PY2p6u" +
           "AirzuR0++W3iqwFcLx3je+kO+H7greADW5vdm8P7wbcJ7wMA1ivH8F65Azz9" +
           "rcB7uHSQBKy8LHk6uh0y402RVZLyK8AL7mseoUeVAOf2fd9TPn4fCJtJtR0E" +
           "LZZOoHknYJ5Ye8bNE+9QwPYQUNXNtYfeDhf1lnEBxnz0LDixIdiKfeY/v/Sb" +
           "f+/9Xwe0RkP3bctJAWx2LoKNs3J3+skvv/L0d738J5+pIj4YOOUnvvXUR0up" +
           "8d20KxO/TIITtZ4q1RKrtTarJenJSrXU7O5sPokdH6xltsdbL/jFx7/ufuFP" +
           "f/6wrbpM3ZcqW59++e/+9dFnX756bjP7/lv2k+fbHDa0FehHjkc4ht57t16q" +
           "FoP/8pUX/8U/fvFTB1SPX9yakUHm//zv/+/fPPr8n/z6bdb993pgNr7tiU2v" +
           "Q1QrGWEnH7axWM5xWclncAa7q/7SH7rEFFuxhNC38EwTsibZEQfjEbWiNzuy" +
           "ZTtk22qgZntMITGKWHyttqD5Prbm0sYgIttkksJDrjMiOZZfswNZiiK+F800" +
           "3wxlZWPKiTUhtRm3mO7jUTPs9dAOUivQ5qir5QtngaC9NlrESBBQWx5t52iv" +
           "tksVZhpvsIClSXuoMDuq2ZTFliSY/WZdjGqJrooFQ+23KzguGtOtRSw9ybD3" +
           "IcWzTbaNSMZoRtP1yVbQB9SsLy6LGQ8PZwxmkAISz/Ct4zDr0VKz+QaRSBtH" +
           "2o8yT8TJHW2t3XQ9DFvCWsgXNmFoYgOr87udiNOOG05nlmbqu45jKD1h6qMF" +
           "Lpio7zNDuT9PtoFGbLrUInOwZDGlp31VIYNYdsesoiqaNl3K7kqg694uQyWO" +
           "S4adLjviyEJcxnC8K5IhrvlaX1vsEqYlRlETxjJnNFbFIbfJiqm5coMejoT9" +
           "zmq1ZtSOg7mMPeB12yckcrjX6qnmY5kbJ8Od27RFn3B9MIbFXun3++3YncuS" +
           "PxYba3ZKr7mEHNHJfBoUDJEirNiMInXB2O0FRURdfbhtmLtUUKa1DZnJFrNq" +
           "TQSbUCOsyzk2l8e8H+MYyYKxG9rJJNst4pFoMaFpMo0sXW2Nroi16rWFLbQ0" +
           "JtXVAITtFp7j4y6ycjTGa6hJYaNMbWDIXmz36sGMAvu+WBUME99Joyk+njjU" +
           "xDFzZdRiuLAvzPkuNXRNrN0dYn7fdBPcFUhvq4h2wY3wjTS1pjzrwg2Mz2jY" +
           "ILQF2Sc2q2mDtgt5FsWexVHZvGVEUzQK1UyV67iyX+X4THA23TaTgw2APFw3" +
           "gzbhLGe9ekysd5u4Pe/tMWPfbzvzzSSXVlpA71ABz9HhcCS0uXxLD1raxFiT" +
           "WxQWVrixaFJNZtpeZsvUbhv1td7b1JOCE2KultpIQXNAirjZFkMQgvU+5nhD" +
           "h4mjEdGrebya7R1iLvmegKszzVU6orQzJbc2UpfLJooM54W07oYdWRpuRVLt" +
           "w4wzVHJmwwwHKbHQ8twmE5OhRRaETp1tSZI6qM1oMef1sEalRt6RxQFpJxsF" +
           "AOEGpOFtMJ8J+RrDWYoygL09RsR0Y0bKfaQbIhsSJpJpreDg/jTkCHFFUzzd" +
           "kuyFR0+l6YDZwNSKJR11kOL1Ud6dxLjLtNRhbK/EMdUR8qK1E/pNem0rDXnS" +
           "kakeJ7dUnJDHMTaXZX0mNmq6XLT1HO8E0gZGLJQeK7VmTEzwnVHsdwlLev1U" +
           "EQVca1C1hB124OWiqBuZv++Ru8TKh/Whia02WCQscJpkBBEf1unV2nX7zDSn" +
           "dAbvE+Qkb0cjg2WwJdHy63NhE2aub3AOgeHWTqY8tmgvGk1YRQYtHN4k/MAg" +
           "GTkd+0raixKJdL2VY8NxvHDMMdqIRBiVZ6TamI+6nOTQ0WagzNZdjCJ6oSrj" +
           "bYJgtEBZ+7w9YgvV0XY+hxv9xnwVD2aMMhwmpE71F3E26w+Vnu9gNjIKAq3Y" +
           "hzC13iFpZ4s4EwoOzEydZjNB2Iljdz3GeNeV0FW+wJNOQ08zmLIzjUcHeDqe" +
           "c27kKVzBMy5fKJ1ldxEGe6em7RvN0TwNFXWobnFdCChSCLChL5m77nzGzvwV" +
           "DW/k1YjJczndyV6d8edrbj3CKH824YZWpi6RqIUvlDEVb+01VluoclHriAXX" +
           "kLRGtOUlGOHCncKypRy51oUNdYn6E1/KZivGXeb10RiEignSGTINgh9sdHZp" +
           "boYkZ/Jda40U6Z5p9Px2MMGSeVfHk6GGJVOB5lpARK4gVrfbQxuJltaa3S5N" +
           "U601vlUkbtNw++Ys4sKamIzT/ixHMQmoZVPRWKV5Qx1SVC5OOayWLBUhm82D" +
           "NSyw8wjPGS4a5+HeENgmP0ZiWUPZJtzT8rGeJ0tpO0T0oq8WbpesWzVF8RNt" +
           "LBO+aPU6BrxU5hnOC8qKYMw5KXOIkC3WariIQkTAA4of+gwRhRG/lvO1wU67" +
           "VKMrDzBRUKKasJSmG2tm2RFS45JFg2hut1F7sfb3WLNR3+i4HhZOusc7zloO" +
           "twW+yXtyj0J3O7/pp/FWNIpoPOhYTT9oM35LoWcsajkIHfPzOtbhW0sUbndT" +
           "aVrDG3qyypU2RqW9rQAMgBLbPqmYY16es2irq/YyBcukrTCcibuVa1KjdKZg" +
           "kb3ayjg2YdxaShBRlHAyWosWm41D8HKBZzZdGEGG1eq0p+PSEG2oMFpXonrb" +
           "WtQ6G9/fcotJUZ+tKRY34GTrY+uc9pHJ1i/kRrfH+/mM6jfbqkkRDZhAegqd" +
           "oB0Y9vzBHg/txcYhJ8sGHKJjfqyL6ZYLWrovAm+g/QWxo0zdBGuAvVRr+d0M" +
           "jsilZHlEQ8+VADb3rkutt0JvI68bSkpyY7QdIY226XPmTJum7cXcm9Z1fjuY" +
           "EslEaPfEOtIZ4LvFQjG5/p4lKCFc9eb2uj4y9Uh1ciRB1KkudaZC1BAVhRuJ" +
           "I3dAwITcHvizkAS7JIJsrbYYTiJ0lLVGTcTS+kRtXt8XSjYRHWPSbKc1asVP" +
           "5tF4MltJ+6mADAoTH1ierrGm1wBxU5O6qDjz5zuiPZltk54vTzR27nuFIY8n" +
           "G2AmfdsUCIraO/q+4frMFl81+aadWus+tSdpy52PcxKJphTdVlUw0s502Z+7" +
           "VjJRYTAcq13cFdsZ5m6i3dAXmj47biJh0dcSj1yqi8mi1U3HGTlg2oWPKqYL" +
           "rDOb5nOpZmzMYqiQgpTXcmNcnzazHNEt2HGTSWcRidqmEUfbudXcu/N1sw33" +
           "upP5uqt0eh5j+Ww8zWrbGWkjRnfQ8pCk7e/WrThTbAQtYJmAO4kvNxAx0dRR" +
           "3w86SywPk31Un28Zpptsrcl6ms4Jf69PGbmbN8cs2maX6DpGm4BU4T4JW3t1" +
           "F0rx2jKocYMPhx1iNCbrvDRGo5UVd9BZVB9HCIrz2zo792rNudptdzOWG66x" +
           "udZuOW2U7BpwGibtLUZLGW0J9mIy6+3Xvu1gq9geWVk00sW4FyN4BIhGQzfL" +
           "cT5GAQPXdg24w1DrVcL7TDubjOFRgZB7a1JTCSJndk1iSU7hSbCCG3A9qEUY" +
           "XlsF6nCm99RwN4abnEAmMmEgLJ3rephNkDai91oTMVvOUZZ2/X4/NEAAxGyV" +
           "65EWPYNTZkSgYqgjNa9pu2prr25njtIxtsTEVZNG0RrDHIdY/bFr4ladmzUn" +
           "W9pr1iVqkrSkOUHXgSW2yabgFLOJv1kWBd20C32J4XjMcxyl5s1+31qHc2zi" +
           "LZPttKUtR/6eA/7SrbOWpVlRt9He0PPVxB+MhCDRhnixZXOpbgEk0jrHl37P" +
           "HaJdmJz4qSPYyGJG7jpWxNttdLPV9Z6p6hYtTc2IoCRXDFexZGewOatbRlgH" +
           "M8TDnoFtZwwz8ge8lG3XYtHVpPmSVYcovMfHyqTI1VkPRGRtJ3lTZ59xEyxQ" +
           "R/q+swynyc72Jk1L2/MoPSUHI5XuOg16PsrUBIG9JY8lK1nmMxyV5PnSwWF4" +
           "ERFhIbkTMl4t/X0h9ZBks3HhTPS1fTGNGrXlvjZMWqHq8lrXXQet3GPS3FV8" +
           "H2H3qw1frDl3UNA5I4YEi/Ybk5Te68VwJymL2Ww4ZOSllIYxPlBQTXA3atTj" +
           "s0228+t1KloQC2NBG6POChOHa0RfyvAYlsE+ABt3NvQYYwjf3bnopiNN5qbl" +
           "bbVpNnJ6uQeWC/O5v4CFvWz4BQHsP9xHXTTTULRubtmgIJcp5dDDvOlt6ruB" +
           "CSa3kbKDOrs3Np35jPFQ3dgs90ve7yuDTcIJs2Z35vhYIWkjM5JroS50qCCt" +
           "C5No2u4huad1u+NJL5/1+riOLWqS0498hN/2hUAR+E2dQ+yC7Q92EdkT0Flz" +
           "ORy77QXbChCUDpxhwtE1xS9QZl40G22tQRCz8Xi5FhtkruB5YtJmkMILUrJW" +
           "E9eOhZ7iUBFKuiKpyFPe8Ad9eqnU1nGrxump2t7ko3WPDeQRo3H7bAFUdTnX" +
           "XeRptMFNJrbFSEKn1BxtjGdTWl5ssshOSMOoE3aG2WSPWBKAZ21WUXjFtXoI" +
           "s+KlAYqoe0xd9OrILDIQFN7pKamis5HdAhveD3+43Ar/+Ns7jXisOmQ5vcX+" +
           "No5X8tt3ePWsw7P7kOoE+7HLF6LnTqvOnW1D5YHD03e6s64OG774iZdfNfkv" +
           "Na4e3wn8aApdO36V4EzOvUDMB+98qsJV9/VnB9W/+on/9pT0Eftjb+Me7z2X" +
           "QF4W+bPcl399+AHjp65C95weW9/yJsHFRs9fPKx+KLbSLA6kC0fWT1+8S3sa" +
           "DOdrx8P62uVDwLP5vP0J4Pcd7OEu9y3/6C5lXyiTV1Lofiu3jCw9XPjtzxnO" +
           "iyl07zZ0zDOL+tybneuc76PK+KmL6j4F1Pzasbpf+86r+7N3KfsnZfJFoFIW" +
           "mNXN/6tnen3pO6HX68d6vf6d1+u1u5T9Ypl8FegVW7fo9U//H/R6osy8CfT5" +
           "5WO9fvk7r9cv3aXsV8rkX6bQI4kdZp5J3tlI79fD0LO04Ezv19+O3nkKPXmn" +
           "VxBOLkC73+7LDYDGnrzlPavDu0HGL7x6/YEnXpX/XXWLf/r+zoMs9MAy87zz" +
           "t17nnq9FsbV0qhF68HAHFlU//zaFnn0zkCn00NmfSrXfOjT+nRR6520bA7Mq" +
           "f87X/b0UunG5bgrdV/2er/cHoLezeoDjDw/nq/xRCt0DqpSP/yF660ON6Uka" +
           "a0YqA0c+3JNXc5VfuRiHTq3h8TezhnOh6/0XYk71It1JfMgOr9K9YHzlVXr8" +
           "w9/sfOnwFoPhaUVRSnmAhe4/vFBxGmPee0dpJ7KuUc9969GvPvg9J8Hw0QPg" +
           "M9c6h+09t39lgPSjtLrkL772xD///p959Y+ru47/C6GNn/LhKAAA");
    }
    public void charDataModified(org.w3c.dom.Node contextNode,
                                 java.lang.String oldValue,
                                 java.lang.String newValue) {
        historyBrowser.
          addCommand(
            createCharDataModifiedCommand(
              contextNode,
              oldValue,
              newValue));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CharDataModifiedCommand createCharDataModifiedCommand(org.w3c.dom.Node contextNode,
                                                                                                                          java.lang.String oldValue,
                                                                                                                          java.lang.String newValue) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CharDataModifiedCommand(
          CHAR_DATA_MODIFIED_COMMAND +
          getBracketedNodeName(
            contextNode),
          contextNode,
          oldValue,
          newValue);
    }
    public static class CharDataModifiedCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Node contextNode;
        protected java.lang.String oldValue;
        protected java.lang.String newValue;
        public CharDataModifiedCommand(java.lang.String commandName,
                                       org.w3c.dom.Node contextNode,
                                       java.lang.String oldValue,
                                       java.lang.String newValue) {
            super(
              );
            setName(
              commandName);
            this.
              contextNode =
              contextNode;
            this.
              oldValue =
              oldValue;
            this.
              newValue =
              newValue;
        }
        public void execute() {  }
        public void undo() { contextNode.
                               setNodeValue(
                                 oldValue);
        }
        public void redo() { contextNode.
                               setNodeValue(
                                 newValue);
        }
        public boolean shouldExecute() { if (contextNode ==
                                               null) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "Qc59kXdZc+k/afdTcqIcAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "/+DNH3/mG9lVxP8CzR+eCScnAAA=");
    }
    public void appendChild(org.w3c.dom.Node parent,
                            org.w3c.dom.Node child) {
        historyBrowser.
          addCommand(
            createAppendChildCommand(
              parent,
              child));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.AppendChildCommand createAppendChildCommand(org.w3c.dom.Node parent,
                                                                                                                org.w3c.dom.Node child) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.AppendChildCommand(
          getAppendChildCommandName(
            parent,
            child),
          parent,
          child);
    }
    public static class AppendChildCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Node oldParentNode;
        protected org.w3c.dom.Node oldNextSibling;
        protected org.w3c.dom.Node parentNode;
        protected org.w3c.dom.Node childNode;
        public AppendChildCommand(java.lang.String commandName,
                                  org.w3c.dom.Node parentNode,
                                  org.w3c.dom.Node childNode) {
            super(
              );
            setName(
              commandName);
            this.
              oldParentNode =
              childNode.
                getParentNode(
                  );
            this.
              oldNextSibling =
              childNode.
                getNextSibling(
                  );
            this.
              parentNode =
              parentNode;
            this.
              childNode =
              childNode;
        }
        public void execute() { parentNode.
                                  appendChild(
                                    childNode);
        }
        public void undo() { if (oldParentNode !=
                                   null) {
                                 oldParentNode.
                                   insertBefore(
                                     childNode,
                                     oldNextSibling);
                             }
                             else {
                                 parentNode.
                                   removeChild(
                                     childNode);
                             } }
        public void redo() { execute(); }
        public boolean shouldExecute() { if (parentNode ==
                                               null ||
                                               childNode ==
                                               null) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "x3T87Jp7/Xt3/fZbfuOZb2U3Ff8LEZWart0nAAA=");
    }
    public void insertChildBefore(org.w3c.dom.Node parent,
                                  org.w3c.dom.Node sibling,
                                  org.w3c.dom.Node child) {
        if (sibling ==
              null) {
            historyBrowser.
              addCommand(
                createAppendChildCommand(
                  parent,
                  child));
        }
        else {
            historyBrowser.
              addCommand(
                createInsertNodeBeforeCommand(
                  parent,
                  sibling,
                  child));
        }
    }
    public org.apache.batik.apps.svgbrowser.UndoableCommand createInsertChildCommand(org.w3c.dom.Node parent,
                                                                                     org.w3c.dom.Node sibling,
                                                                                     org.w3c.dom.Node child) {
        if (sibling ==
              null) {
            return createAppendChildCommand(
                     parent,
                     child);
        }
        else {
            return createInsertNodeBeforeCommand(
                     parent,
                     sibling,
                     child);
        }
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.InsertNodeBeforeCommand createInsertNodeBeforeCommand(org.w3c.dom.Node parent,
                                                                                                                          org.w3c.dom.Node sibling,
                                                                                                                          org.w3c.dom.Node child) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.InsertNodeBeforeCommand(
          getInsertBeforeCommandName(
            parent,
            child,
            sibling),
          parent,
          sibling,
          child);
    }
    public static class InsertNodeBeforeCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Node oldParent;
        protected org.w3c.dom.Node oldNextSibling;
        protected org.w3c.dom.Node newNextSibling;
        protected org.w3c.dom.Node parent;
        protected org.w3c.dom.Node child;
        public InsertNodeBeforeCommand(java.lang.String commandName,
                                       org.w3c.dom.Node parent,
                                       org.w3c.dom.Node sibling,
                                       org.w3c.dom.Node child) {
            super(
              );
            setName(
              commandName);
            this.
              oldParent =
              child.
                getParentNode(
                  );
            this.
              oldNextSibling =
              child.
                getNextSibling(
                  );
            this.
              parent =
              parent;
            this.
              child =
              child;
            this.
              newNextSibling =
              sibling;
        }
        public void execute() { if (newNextSibling !=
                                      null) {
                                    parent.
                                      insertBefore(
                                        child,
                                        newNextSibling);
                                }
                                else {
                                    parent.
                                      appendChild(
                                        child);
                                } }
        public void undo() { if (oldParent !=
                                   null) {
                                 oldParent.
                                   insertBefore(
                                     child,
                                     oldNextSibling);
                             }
                             else {
                                 parent.
                                   removeChild(
                                     child);
                             } }
        public void redo() { execute(); }
        public boolean shouldExecute() { if (parent ==
                                               null ||
                                               child ==
                                               null) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "ujDyXVcZlrzohUY2yLhvsC5tPvgPj2QO0vkdAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "Jneg6qQoAAA=");
    }
    public void replaceChild(org.w3c.dom.Node parent,
                             org.w3c.dom.Node newChild,
                             org.w3c.dom.Node oldChild) {
        
    }
    public static class ReplaceChildCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Node oldParent;
        protected org.w3c.dom.Node oldNextSibling;
        protected org.w3c.dom.Node newNextSibling;
        protected org.w3c.dom.Node parent;
        protected org.w3c.dom.Node child;
        public ReplaceChildCommand(java.lang.String commandName,
                                   org.w3c.dom.Node parent,
                                   org.w3c.dom.Node sibling,
                                   org.w3c.dom.Node child) {
            super(
              );
            setName(
              commandName);
            this.
              oldParent =
              child.
                getParentNode(
                  );
            this.
              oldNextSibling =
              child.
                getNextSibling(
                  );
            this.
              parent =
              parent;
            this.
              child =
              child;
            this.
              newNextSibling =
              sibling;
        }
        public void execute() { if (newNextSibling !=
                                      null) {
                                    parent.
                                      insertBefore(
                                        child,
                                        newNextSibling);
                                }
                                else {
                                    parent.
                                      appendChild(
                                        child);
                                } }
        public void undo() { if (oldParent !=
                                   null) {
                                 oldParent.
                                   insertBefore(
                                     child,
                                     oldNextSibling);
                             }
                             else {
                                 parent.
                                   removeChild(
                                     child);
                             } }
        public void redo() { execute(); }
        public boolean shouldExecute() { if (parent ==
                                               null ||
                                               child ==
                                               null) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "KAxHXnLDIhtk3LdZlzbv/weayCwN8R0AAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "WW6YXdAnf3jHH7zxt5/+dnad8b8vUz41mCgAAA==");
    }
    public void removeChild(org.w3c.dom.Node parent,
                            org.w3c.dom.Node child) {
        historyBrowser.
          addCommand(
            createRemoveChildCommand(
              parent,
              child));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.RemoveChildCommand createRemoveChildCommand(org.w3c.dom.Node parent,
                                                                                                                org.w3c.dom.Node child) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.RemoveChildCommand(
          getRemoveChildCommandName(
            parent,
            child),
          parent,
          child);
    }
    public static class RemoveChildCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Node parentNode;
        protected org.w3c.dom.Node childNode;
        protected int indexInChildrenArray;
        public RemoveChildCommand(java.lang.String commandName,
                                  org.w3c.dom.Node parentNode,
                                  org.w3c.dom.Node childNode) {
            super(
              );
            setName(
              commandName);
            this.
              parentNode =
              parentNode;
            this.
              childNode =
              childNode;
        }
        public void execute() { indexInChildrenArray =
                                  org.apache.batik.dom.util.DOMUtilities.
                                    getChildIndex(
                                      childNode,
                                      parentNode);
                                parentNode.
                                  removeChild(
                                    childNode);
        }
        public void undo() { org.w3c.dom.Node refChild =
                               parentNode.
                               getChildNodes(
                                 ).
                               item(
                                 indexInChildrenArray);
                             parentNode.insertBefore(
                                          childNode,
                                          refChild);
        }
        public void redo() { parentNode.removeChild(
                                          childNode);
        }
        public boolean shouldExecute() { if (parentNode ==
                                               null ||
                                               childNode ==
                                               null) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "ya/nR/f/Cw2LhrhXJwAA");
    }
    public void setNodeValue(org.w3c.dom.Node contextNode,
                             java.lang.String newValue) {
        historyBrowser.
          addCommand(
            createChangeNodeValueCommand(
              contextNode,
              newValue));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.ChangeNodeValueCommand createChangeNodeValueCommand(org.w3c.dom.Node contextNode,
                                                                                                                        java.lang.String newValue) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.ChangeNodeValueCommand(
          getChangeNodeValueCommandName(
            contextNode,
            newValue),
          contextNode,
          newValue);
    }
    public static class ChangeNodeValueCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Node contextNode;
        protected java.lang.String newValue;
        public ChangeNodeValueCommand(java.lang.String commandName,
                                      org.w3c.dom.Node contextNode,
                                      java.lang.String newValue) {
            super(
              );
            setName(
              commandName);
            this.
              contextNode =
              contextNode;
            this.
              newValue =
              newValue;
        }
        public void execute() { java.lang.String oldNodeValue =
                                  contextNode.
                                  getNodeValue(
                                    );
                                contextNode.
                                  setNodeValue(
                                    newValue);
                                newValue =
                                  oldNodeValue;
        }
        public void undo() { execute(); }
        public void redo() { execute(); }
        public boolean shouldExecute() { if (contextNode ==
                                               null) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "8LlmJgAA");
    }
    public org.apache.batik.apps.svgbrowser.AbstractCompoundCommand getCurrentCompoundCommand() {
        if (currentCompoundCommand ==
              null) {
            currentCompoundCommand =
              createCompoundUpdateCommand(
                OUTER_EDIT_COMMAND);
        }
        return currentCompoundCommand;
    }
    public void addToCurrentCompoundCommand(org.apache.batik.apps.svgbrowser.AbstractUndoableCommand cmd) {
        getCurrentCompoundCommand(
          ).
          addCommand(
            cmd);
        historyBrowser.
          fireDoCompoundEdit(
            new org.apache.batik.apps.svgbrowser.HistoryBrowser.HistoryBrowserEvent(
              getCurrentCompoundCommand(
                )));
    }
    public void performCurrentCompoundCommand() {
        if (getCurrentCompoundCommand(
              ).
              getCommandNumber(
                ) >
              0) {
            historyBrowser.
              addCommand(
                getCurrentCompoundCommand(
                  ));
            historyBrowser.
              fireCompoundEditPerformed(
                new org.apache.batik.apps.svgbrowser.HistoryBrowser.HistoryBrowserEvent(
                  currentCompoundCommand));
            currentCompoundCommand =
              null;
        }
    }
    private java.lang.String getNodeAsString(org.w3c.dom.Node node) {
        java.lang.String id =
          "";
        if (node.
              getNodeType(
                ) ==
              org.w3c.dom.Node.
                ELEMENT_NODE) {
            org.w3c.dom.Element e =
              (org.w3c.dom.Element)
                node;
            id =
              e.
                getAttributeNS(
                  null,
                  org.apache.batik.util.SVGConstants.
                    SVG_ID_ATTRIBUTE);
        }
        if (id.
              length(
                ) !=
              0) {
            return node.
              getNodeName(
                ) +
            " \"" +
            id +
            "\"";
        }
        return node.
          getNodeName(
            );
    }
    private java.lang.String getBracketedNodeName(org.w3c.dom.Node node) {
        return "(" +
        getNodeAsString(
          node) +
        ")";
    }
    private java.lang.String getAppendChildCommandName(org.w3c.dom.Node parentNode,
                                                       org.w3c.dom.Node childNode) {
        return "Append " +
        getNodeAsString(
          childNode) +
        " to " +
        getNodeAsString(
          parentNode);
    }
    private java.lang.String getInsertBeforeCommandName(org.w3c.dom.Node parentNode,
                                                        org.w3c.dom.Node childNode,
                                                        org.w3c.dom.Node siblingNode) {
        return "Insert " +
        getNodeAsString(
          childNode) +
        " to " +
        getNodeAsString(
          parentNode) +
        " before " +
        getNodeAsString(
          siblingNode);
    }
    private java.lang.String getRemoveChildCommandName(org.w3c.dom.Node parent,
                                                       org.w3c.dom.Node child) {
        return "Remove " +
        getNodeAsString(
          child) +
        " from " +
        getNodeAsString(
          parent);
    }
    private java.lang.String getChangeNodeValueCommandName(org.w3c.dom.Node contextNode,
                                                           java.lang.String newValue) {
        return "Change " +
        getNodeAsString(
          contextNode) +
        " value to " +
        newValue;
    }
    private java.lang.String getNodeChangedCommandName(org.w3c.dom.Node node) {
        return "Node " +
        getNodeAsString(
          node) +
        " changed";
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "UgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "0Lpa8VTV3BTnE7SekANF6tbHilKtxTbp");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "5ptK/X8mn4iKwl8AAA==");
}
