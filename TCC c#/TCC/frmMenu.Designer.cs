namespace TCC
{
    partial class frmMenu
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.btnEditPerfilUsuario = new System.Windows.Forms.Button();
            this.btnEditarPrestador = new System.Windows.Forms.Button();
            this.button3 = new System.Windows.Forms.Button();
            this.button4 = new System.Windows.Forms.Button();
            this.panel1 = new System.Windows.Forms.Panel();
            this.panel3 = new System.Windows.Forms.Panel();
            this.label1 = new System.Windows.Forms.Label();
            this.panel2 = new System.Windows.Forms.Panel();
            this.panel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // btnEditPerfilUsuario
            // 
            this.btnEditPerfilUsuario.Font = new System.Drawing.Font("Gilroy ExtraBold", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnEditPerfilUsuario.Location = new System.Drawing.Point(56, 102);
            this.btnEditPerfilUsuario.Name = "btnEditPerfilUsuario";
            this.btnEditPerfilUsuario.Size = new System.Drawing.Size(154, 90);
            this.btnEditPerfilUsuario.TabIndex = 0;
            this.btnEditPerfilUsuario.Text = "Editar perfil de Usuário";
            this.btnEditPerfilUsuario.UseVisualStyleBackColor = true;
            this.btnEditPerfilUsuario.Click += new System.EventHandler(this.btnEditPerfilUsuario_Click);
            // 
            // btnEditarPrestador
            // 
            this.btnEditarPrestador.Font = new System.Drawing.Font("Gilroy ExtraBold", 10.2F, System.Drawing.FontStyle.Bold);
            this.btnEditarPrestador.Location = new System.Drawing.Point(242, 102);
            this.btnEditarPrestador.Name = "btnEditarPrestador";
            this.btnEditarPrestador.Size = new System.Drawing.Size(154, 90);
            this.btnEditarPrestador.TabIndex = 1;
            this.btnEditarPrestador.Text = "Editar prestador de serviço";
            this.btnEditarPrestador.UseVisualStyleBackColor = true;
            this.btnEditarPrestador.Click += new System.EventHandler(this.btnEditarPrestador_Click);
            // 
            // button3
            // 
            this.button3.Location = new System.Drawing.Point(427, 103);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(154, 90);
            this.button3.TabIndex = 2;
            this.button3.Text = "Editar perfil";
            this.button3.UseVisualStyleBackColor = true;
            // 
            // button4
            // 
            this.button4.Location = new System.Drawing.Point(608, 103);
            this.button4.Name = "button4";
            this.button4.Size = new System.Drawing.Size(154, 90);
            this.button4.TabIndex = 3;
            this.button4.Text = "Editar perfil";
            this.button4.UseVisualStyleBackColor = true;
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.SystemColors.MenuHighlight;
            this.panel1.Controls.Add(this.panel3);
            this.panel1.Controls.Add(this.label1);
            this.panel1.Controls.Add(this.panel2);
            this.panel1.Controls.Add(this.btnEditPerfilUsuario);
            this.panel1.Controls.Add(this.button4);
            this.panel1.Controls.Add(this.btnEditarPrestador);
            this.panel1.Controls.Add(this.button3);
            this.panel1.Location = new System.Drawing.Point(-2, -3);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(803, 458);
            this.panel1.TabIndex = 4;
            // 
            // panel3
            // 
            this.panel3.BackColor = System.Drawing.Color.LightGray;
            this.panel3.ForeColor = System.Drawing.Color.LightGray;
            this.panel3.Location = new System.Drawing.Point(159, 72);
            this.panel3.Name = "panel3";
            this.panel3.Size = new System.Drawing.Size(84, 2);
            this.panel3.TabIndex = 5;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Calibri", 13F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.LightGray;
            this.label1.Location = new System.Drawing.Point(89, 59);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(67, 27);
            this.label1.TabIndex = 5;
            this.label1.Text = "Editar";
            // 
            // panel2
            // 
            this.panel2.BackColor = System.Drawing.Color.LightGray;
            this.panel2.ForeColor = System.Drawing.Color.LightGray;
            this.panel2.Location = new System.Drawing.Point(56, 72);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(27, 2);
            this.panel2.TabIndex = 4;
            // 
            // frmMenu
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.panel1);
            this.Name = "frmMenu";
            this.Text = "frmMenu";
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btnEditPerfilUsuario;
        private System.Windows.Forms.Button btnEditarPrestador;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.Button button4;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.Panel panel3;
        private System.Windows.Forms.Label label1;
    }
}