package com.cds.lsp.plugin

import com.intellij.execution.ExecutionException
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.javascript.nodejs.interpreter.NodeCommandLineConfigurator
import com.intellij.javascript.nodejs.interpreter.NodeJsInterpreterManager
import com.intellij.javascript.nodejs.interpreter.NodeJsInterpreter
import com.intellij.lang.javascript.service.JSLanguageServiceUtil
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor

class CdsLspServerDescriptor(project: Project) : ProjectWideLspServerDescriptor(project, "Cds") {

    override fun isSupportedFile(file: VirtualFile) = file.extension == "cds"

    override fun createCommandLine(): GeneralCommandLine {
        val interpreter = NodeJsInterpreterManager.getInstance(project).interpreter as NodeJsInterpreter

        val lsp = JSLanguageServiceUtil.getPluginDirectory(
            javaClass,
            "language-server/node_modules/@sap/cds-lsp/dist/main.js"
        )
        if (lsp == null || !lsp.exists()) {
            // broken plugin installation?
            throw ExecutionException("CDS language server was not found.")
        }

        return GeneralCommandLine().apply {
            withParentEnvironmentType(GeneralCommandLine.ParentEnvironmentType.CONSOLE)
            withCharset(Charsets.UTF_8)
            addParameter(lsp.path)
            addParameter("--stdio")

            NodeCommandLineConfigurator.find(interpreter)
                .configure(this, NodeCommandLineConfigurator.defaultOptions(project))
        }
    }

}