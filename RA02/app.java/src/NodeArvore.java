public class NodeArvore {
  private Integer Dado;
  private NodeArvore NodeEsquerdo;
  private NodeArvore NodeDireito;

  public NodeArvore(){
    this.Dado = null;
    this.NodeEsquerdo = null;
    this.NodeDireito = null;    
  }

  public void setDado(Integer Valor){
    this.Dado = Valor;
  }

  public Integer getDado(){
    return Dado;
  }

  public void setNodeEsquerdo(NodeArvore NodeEsquerdo){
    this.NodeEsquerdo = NodeEsquerdo;
  }

  public NodeArvore getNodeEsquerdo(){
    return NodeEsquerdo;
  }

  public void setNodeDireito(NodeArvore NodeDireito){
    this.NodeDireito = NodeDireito;
  }

  public NodeArvore getNodeDireito(){
    return NodeDireito;
  }

}
