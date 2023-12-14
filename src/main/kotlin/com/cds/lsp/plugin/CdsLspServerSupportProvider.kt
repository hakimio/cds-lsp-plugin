package com.cds.lsp.plugin

import com.intellij.javascript.nodejs.interpreter.NodeJsInterpreterManager
import com.intellij.javascript.nodejs.interpreter.local.NodeJsLocalInterpreter
import com.intellij.javascript.nodejs.interpreter.wsl.WslNodeInterpreter
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.LspServerSupportProvider

class CdsLspServerSupportProvider : LspServerSupportProvider {
    override fun fileOpened(project: Project, file: VirtualFile, serverStarter: LspServerSupportProvider.LspServerStarter) {
        if (file.extension != "cds") return

        val node = NodeJsInterpreterManager.getInstance(project).interpreter
        if (node !is NodeJsLocalInterpreter && node !is WslNodeInterpreter) return

        serverStarter.ensureServerStarted(CdsLspServerDescriptor(project))
    }
}
