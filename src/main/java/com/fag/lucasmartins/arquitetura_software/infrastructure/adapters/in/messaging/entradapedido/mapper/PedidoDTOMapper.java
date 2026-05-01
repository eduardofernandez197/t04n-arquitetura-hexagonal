package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradapedido.mapper;

import java.util.ArrayList;
import java.util.List;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoProdutoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradapedido.dto.OrderItemsDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradapedido.dto.PedidoDTO;

public class PedidoDTOMapper {

    public static PedidoBO toBo(PedidoDTO dto) {

        PedidoBO bo = new PedidoBO();

        PessoaBO pessoa = new PessoaBO();
        pessoa.setId(dto.getCustomerId());
        bo.setCep(dto.getZipCode());
        bo.setPessoa(pessoa);

        final List<PedidoProdutoBO> itens = new ArrayList<>();
        for (OrderItemsDTO item : dto.getOrderItems()) {
            PedidoProdutoBO pedidoProduto = new PedidoProdutoBO();
            ProdutoBO produto = new ProdutoBO();
            produto.setId(item.getSku());
            pedidoProduto.setQuantidade(item.getAmount());
            pedidoProduto.setProduto(produto);
            itens.add(pedidoProduto);
        }
        bo.setItens(itens);

        return bo;

    }

}
