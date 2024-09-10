## CDS Language Support for JetBrains IDEs

## NOTICE: Use [official plugin](https://plugins.jetbrains.com/plugin/25209-sap-cds-language-support) from SAP instead :warning:

Experimental CDS language support for JetBrains IDEs using 
[JetBrains Language Server Protocol support](https://blog.jetbrains.com/platform/2023/07/lsp-for-plugin-developers/) 
and [@sap/cds-lsp](https://www.npmjs.com/package/@sap/cds-lsp) node package.

![cds-autocompletion](https://github.com/hakimio/cds-lsp-plugin/assets/768105/ef5feab4-5206-4e79-8dff-6356158f3301)
![cds-error](https://github.com/hakimio/cds-lsp-plugin/assets/768105/42c49789-672a-441b-bafb-864a7c763627)

### Installation

- Download and install plugin from [GitHub release](https://github.com/hakimio/cds-lsp-plugin/releases) page
- Install TextMate syntax highlighting bundle from [@sap/cds-lsp](https://www.npmjs.com/package/@sap/cds-lsp) library.
The bundle is located in `@sap\cds-lsp\syntaxes` directory. "TextMate Bundles" IDE plugin has to be enabled to install
the bundle.

### Experimental

This is pre-alpha state experimental plugin. It can do basic auto-completion and syntax validation which sometimes
breaks when SAP language server stops responding. Contributions to improve the plugin are welcome.

### Development

The plugin was created with "IntelliJ IDEA". It requires "IntelliJ IDEA IU-233" SDK and LSP library found in 
`IntelliJ IDEA 2023.3/lib/src/src_lsp-openapi.zip`. It's based on 
[JetBrains Prisma LSP plugin](https://github.com/JetBrains/intellij-plugins/tree/master/prisma/src/org/intellij/prisma/ide/lsp).
