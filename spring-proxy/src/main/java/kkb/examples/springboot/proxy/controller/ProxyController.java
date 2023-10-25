package kkb.examples.springboot.proxy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.mvc.ProxyExchange;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import kkb.examples.springboot.proxy.config.ProxyConfig;

@RestController
public class ProxyController {

    private static final Logger LOG = LoggerFactory.getLogger(ProxyController.class);
    private static final String PREFIX = "/proxy";

    private final ProxyConfig config;

    public ProxyController(ProxyConfig config) {
        this.config = config;
    }

    @GetMapping(PREFIX + "/**")
    public ResponseEntity<?> proxyGet(ProxyExchange<Object> proxy) {
        LOG.info("PROXY GET {}", proxy.path());
        return proxy.uri(config.getTargetUrl() + removePrefix(proxy.path())).get();
    }

    @PutMapping(PREFIX + "/**")
    public ResponseEntity<?> proxyPut(ProxyExchange<Object> proxy) {
        LOG.info("PROXY PUT {}", proxy.path());
        return proxy.uri(config.getTargetUrl() + removePrefix(proxy.path())).put();
    }

    @PostMapping(PREFIX + "/**")
    public ResponseEntity<?> proxyPost(ProxyExchange<Object> proxy) {
        LOG.info("PROXY POST {}", proxy.path());
        return proxy.uri(config.getTargetUrl() + removePrefix(proxy.path())).post();
    }

    @DeleteMapping(PREFIX + "/**")
    public ResponseEntity<?> proxyDelete(ProxyExchange<Object> proxy) {
        LOG.info("PROXY DELETE {}", proxy.path());
        return proxy.uri(config.getTargetUrl() + removePrefix(proxy.path())).delete();
    }

    @PatchMapping(PREFIX + "/**")
    public ResponseEntity<?> proxyPatch(ProxyExchange<Object> proxy) {
        LOG.info("PROXY PATCH {}", proxy.path());
        return proxy.uri(config.getTargetUrl() + removePrefix(proxy.path())).patch();
    }

    private static String removePrefix(String path) {
        return path.substring(PREFIX.length(), path.length());
    }

}
