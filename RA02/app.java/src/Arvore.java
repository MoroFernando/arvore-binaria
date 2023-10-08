public class Arvore {
  private NodeArvore Raiz;

  public Arvore(){
    this.Raiz = null;
  }

  public void insere(Integer Valor){
    //cria o novo nó a ser inserido
    NodeArvore NovoNode = new NodeArvore();
    NovoNode.setDado(Valor);

    //INSERE caso arvore vazia
    if(this.Raiz == null){
      this.Raiz = NovoNode;

    //INSERE caso arvore n esteja vazia
    } else {
    //cria instancia para percorrer os nós da árvore
    NodeArvore NodeAtual = new NodeArvore();
    NodeAtual = Raiz;

      while(true){
        if(NovoNode.getDado() <= NodeAtual.getDado()){
          if(NodeAtual.getNodeEsquerdo() != null){
            NodeAtual = NodeAtual.getNodeEsquerdo();
          } else {
            NodeAtual.setNodeEsquerdo(NovoNode);
            break;
          }
        }else{
          if(NodeAtual.getNodeDireito() != null){
            NodeAtual = NodeAtual.getNodeDireito();
          } else {
            NodeAtual.setNodeDireito(NovoNode);
            break;
          }
        }
      }

    }

  }

  public NodeArvore busca(Integer Valor){
    NodeArvore NodeAtual = new NodeArvore();
    NodeAtual = Raiz;

    while(NodeAtual != null && NodeAtual.getDado() != Valor){
      if(Valor <= NodeAtual.getDado()){
        NodeAtual = NodeAtual.getNodeEsquerdo();
      }else{
        NodeAtual = NodeAtual.getNodeDireito();
      }
    }

    if(NodeAtual != null){
      return NodeAtual;
    } else {
      return null;
    }
  }

  public void remove(Integer Valor) {
    Raiz = removeRec(Raiz, Valor);
}

  private NodeArvore removeRec(NodeArvore raiz, Integer Valor) {
    if (raiz == null) {
        return raiz; // O nó não existe na árvore.
    }

    // Caso o valor seja menor que o valor do nó atual, recursivamente remova à esquerda.
    if (Valor < raiz.getDado()) {
        raiz.setNodeEsquerdo(removeRec(raiz.getNodeEsquerdo(), Valor));
    }
    // Caso o valor seja maior que o valor do nó atual, recursivamente remova à direita.
    else if (Valor > raiz.getDado()) {
        raiz.setNodeDireito(removeRec(raiz.getNodeDireito(), Valor));
    }
    // Caso contrário, este é o nó a ser removido.
    else {
        // Nó com apenas um filho ou sem filhos.
        if (raiz.getNodeEsquerdo() == null) {
            return raiz.getNodeDireito();
        } else if (raiz.getNodeDireito() == null) {
            return raiz.getNodeEsquerdo();
        }

        // Nó com dois filhos, encontre o sucessor in-order (o menor nó na subárvore direita).
        raiz.setDado(minValue(raiz.getNodeDireito()));

        // Remova o sucessor in-order.
        raiz.setNodeDireito(removeRec(raiz.getNodeDireito(), raiz.getDado()));
    }
    return raiz;
}

  private Integer minValue(NodeArvore node) {
    Integer minValue = node.getDado();
    while (node.getNodeEsquerdo() != null) {
        minValue = node.getNodeEsquerdo().getDado();
        node = node.getNodeEsquerdo();
    }
    return minValue;
}

}
