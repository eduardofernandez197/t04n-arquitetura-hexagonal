package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradapedido.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PedidoServicePort;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradapedido.dto.PedidoDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradapedido.mapper.PedidoDTOMapper;

import io.awspring.cloud.sqs.annotation.SqsListener;

@Component
public class PedidoSqsAdapter {

    private static final Logger log = LoggerFactory.getLogger(PedidoSqsAdapter.class);

    @Autowired
    private PedidoServicePort orderService;

    @SqsListener("${queue.order-events}")
    public void listen(PedidoDTO dto) {
        try {
            log.info("Mensagem recebida do SQS para pedido do cliente ID: {}", dto.getCustomerId());
            log.debug("Detalhes da mensagem recebida: zipCode={}, customerId={}, orderItems={}",
                    dto.getZipCode(), dto.getCustomerId(),
                    dto.getOrderItems() != null ? dto.getOrderItems().size() : 0);

            log.info("Iniciando processamento do pedido para cliente {}", dto.getCustomerId());
            orderService.criarPedido(PedidoDTOMapper.toBo(dto));
            log.info("Pedido processado com sucesso para cliente {}", dto.getCustomerId());

        } catch (Exception e) {
            log.error("Erro ao processar mensagem do SQS para cliente {}: {}", dto.getCustomerId(), e.getMessage(), e);
            throw e; // Re-throw para que o SQS possa tentar novamente ou mover para DLQ
        }
    }
}