package app;

import static spark.Spark.*;
import service.ProdutoService;

public class Aplicacao {
    
    private static final int PORTA_PADRAO = 8080;
    private static ProdutoService produtoService = new ProdutoService();
    
    public static void main(String[] args) {
        // Definindo a porta para o Spark se vincular
        port(PORTA_PADRAO);
        
        // Restante do seu código Spark aqui...
        // Definição de arquivos estáticos
        staticFiles.location("/public");
        
        // Rotas para manipulação de produtos
        post("/produto/insert", (request, response) -> produtoService.insert(request, response));

        get("/produto/:id", (request, response) -> produtoService.get(request, response));
        
        get("/produto/list/:orderby", (request, response) -> produtoService.getAll(request, response));

        get("/produto/update/:id", (request, response) -> produtoService.getToUpdate(request, response));
        
        post("/produto/update/:id", (request, response) -> produtoService.update(request, response));
           
        get("/produto/delete/:id", (request, response) -> produtoService.delete(request, response));
    }
}
