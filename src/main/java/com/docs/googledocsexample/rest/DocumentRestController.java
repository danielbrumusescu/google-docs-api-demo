package com.docs.googledocsexample.rest;

import com.docs.googledocsexample.obj.AddTextRequest;
import com.docs.googledocsexample.obj.ReadDocumentResponse;
import com.docs.googledocsexample.service.DocumentService;
import com.google.api.services.docs.v1.model.BatchUpdateDocumentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("documents")
public class DocumentRestController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/{id}")
    public ReadDocumentResponse readDocument(@PathVariable String id) throws IOException {
        return documentService.readDocument(id);
    }

    @PutMapping("/{id}")
    public BatchUpdateDocumentResponse updateDocument(@RequestBody AddTextRequest addTextRequest, @PathVariable String id) throws IOException {
        return documentService.addText(addTextRequest,id);
    }
}
