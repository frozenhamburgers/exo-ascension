#version 150

in vec2 Position;       // Comes from DefaultVertexFormat.BLIT_SCREEN
out vec2 texCoord;      // Passed to fragment shader

void main() {
    texCoord = (Position + 1.0) * 0.5; // Convert from [-1,1] to [0,1]
    gl_Position = vec4(Position, 0.0, 1.0);
}