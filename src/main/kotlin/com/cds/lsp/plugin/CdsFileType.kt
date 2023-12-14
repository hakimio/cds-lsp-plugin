package com.cds.lsp.plugin

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object CdsFileType: LanguageFileType(CdsLanguage) {
    override fun getName(): String = "Cds"

    override fun getDescription(): String = "SAP CDS file type"

    override fun getDefaultExtension(): String = "cds"

    override fun getIcon(): Icon = CdsIcons.FILE
}