package resolver

import (
	gResolver "google.golang.org/grpc/resolver"
)

type IResolver interface {
	NewResolver() (gResolver.Builder, error)
}
